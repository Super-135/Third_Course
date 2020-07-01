package com.Super135.Lesson1;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0f;
    private static final String NAME = "Яблоко";

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public float getWEIGHT() {
        return WEIGHT;
    }

}
