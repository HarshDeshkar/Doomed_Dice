package com.Doomed.Dice.entity;

public class DiceEntity {

    private int[] faces;

    public DiceEntity(int[] faces) {
        this.faces = faces;
    }

    public int[] getFaces() {
        return faces;
    }
}
