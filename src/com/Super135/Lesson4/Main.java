package com.Super135.Lesson4;

public class Main {
    static Object monitor = new Object();
    static volatile char current = 'A';
    static final int COUNT = 5;

    public static void main(String[] args) {
        // Просто создаем три потока. Каждый выводит свою букву.
        new Thread(() -> {
            try {
                for (int i = 0; i < COUNT; i++) {
                    synchronized (monitor) {
                        while (current != 'A'){
                            monitor.wait();
                        }
                        System.out.print('A');
                        current = 'B';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < COUNT; i++) {
                    synchronized (monitor) {
                        while (current != 'B'){
                            monitor.wait();
                        }
                        System.out.print('B');
                        current = 'C';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                for (int i = 0; i < COUNT; i++) {
                    synchronized (monitor) {
                        while (current != 'C'){
                            monitor.wait();
                        }
                        System.out.print('C');
                        current = 'A';
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e ) {
                e.printStackTrace();
            }
        }).start();
    }

}
