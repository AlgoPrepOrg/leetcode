package io.algopreorg.alog.orderedstream;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream3 {

    private final String[] stream;
    private final int n;
    private int pointer = 0;

    public OrderedStream3(int n) {
        this.n = n;
        this.stream = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey - 1] = value;

        while (pointer < n && stream[pointer] != null) {
            result.add(stream[pointer]);
            pointer++;
        }
        return result;
    }

}
