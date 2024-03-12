package io.algopreorg.alog.deadlock;

import lombok.SneakyThrows;

public class DemoApp {

    @SneakyThrows
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread thread = new Thread(() -> {
            synchronized (a) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b) {
                    b.saySome();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (b) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (a) {
                    a.say();
                }
            }
        });

        Thread state = new Thread(() -> {
            while (true) {
                System.out.println("State of thread " + thread.getState());
                System.out.println("State of thread " + thread2.getState());
            }
        });

        thread.start();
        thread2.start();
        state.start();
    }
}
