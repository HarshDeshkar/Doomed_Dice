package com.Doomed.Dice.entity;

public class TransformationResult {
    private final int[] newDieA;
    private final int[] newDieB;

    public TransformationResult(int[] newDieA, int[] newDieB) {
        this.newDieA = newDieA;
        this.newDieB = newDieB;
    }

    public int[] getNewDieA() {
        return newDieA;
    }

    public int[] getNewDieB() {
        return newDieB;
    }
}