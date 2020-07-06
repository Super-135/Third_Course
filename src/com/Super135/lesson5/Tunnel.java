package com.Super135.lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore colTunel;
    public Tunnel() {
        colTunel = new Semaphore(MainClass.CARS_COUNT/2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                if(!colTunel.tryAcquire()) {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    colTunel.acquire();
                }
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                colTunel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
