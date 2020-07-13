package com.Super135.Lesson7;

public class Main {
    public static void main(String[] args) {
        try {
            Start.start(Tests.class);   //Tests.class
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

    }
}
