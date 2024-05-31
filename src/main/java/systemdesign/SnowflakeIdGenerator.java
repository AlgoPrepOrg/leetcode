package systemdesign;

import lombok.SneakyThrows;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ThreadLocalRandom;

public class SnowflakeIdGenerator {

    private static final long epoch = 1288834974657L; // Twitter epoch (Nov 04, 2010, 01:42:54 UTC)
    private static final long datacenterIdBits = 5L;
    private static final long workerIdBits = 5L;
    private static final long sequenceBits = 12L;

    private static final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);
    private static final long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private static final long sequenceMask = -1L ^ (-1L << sequenceBits);

    private final long workerIdShift = sequenceBits;
    private final long datacenterIdShift = sequenceBits + workerIdBits;
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    private long datacenterId;
    private long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    @SneakyThrows
    public static void main(String[] args) {
        List<Thread> threadList = new ArrayList<>();
        Set<Long> list = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                int randomDataCenter = ThreadLocalRandom.current().nextInt(32);
                int randomMachine = ThreadLocalRandom.current().nextInt(32);
                SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(randomDataCenter, randomMachine);
                for (int j = 0; j < 1000; j++) {
                    var id = snowflakeIdGenerator.nextId();
                    System.out.printf("Current thread: %s generated id: %s%n", Thread.currentThread().getName(), id);
                    if(!list.add(id)) {
                        throw new RuntimeException("There is already such id: " + id);
                    }
                }
            });
            threadList.add(thread);
        }

        for (var thread: threadList) {
            thread.start();
        }
        for (var thread : threadList) {
            thread.join();
        }
    }

    public SnowflakeIdGenerator(long datacenterId, long workerId) {
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("Datacenter ID can't be greater than %d or less than 0", maxDatacenterId));
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("Worker ID can't be greater than %d or less than 0", maxWorkerId));
        }
        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - epoch) << timestampLeftShift)
                | (datacenterId << datacenterIdShift)
                | (workerId << workerIdShift)
                | sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }
}
