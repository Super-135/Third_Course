package com.Super135;

public class Orange extends Fruit {
    private static final float WEIGHT = 1.5f;
    private static final String NAME = "Апельсин";

    @Override
    public String toString() {
        return NAME;
    }

    @Override
    public float getWEIGHT() {
        return this.WEIGHT;
    }
}
