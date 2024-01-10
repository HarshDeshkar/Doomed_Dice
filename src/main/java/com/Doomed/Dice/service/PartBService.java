package com.Doomed.Dice.service;

import java.util.Arrays;
import java.util.List;

import com.Doomed.Dice.entity.DiceEntity;
import com.Doomed.Dice.entity.TransformationResult;
import com.Doomed.Dice.repositories.DiceRepository;

public class PartBService {

    private final DiceRepository diceRepository;

    public PartBService(DiceRepository diceRepository) {
        this.diceRepository = diceRepository;
    }

    public List<DiceEntity> getAllDice() {
        return diceRepository.getAllDice();
    }

    public DiceEntity saveDice(DiceEntity dice) {
        return diceRepository.saveDice(dice);
    }

    public TransformationResult undoom_dice(int[] dieA, int[] dieB) {
        int numberOfFaces = dieA.length;
        int[] newDieA = new int[numberOfFaces];
        int[] newDieB = new int[numberOfFaces];

        for (int i = 0; i < numberOfFaces; i++) {
            // Apply conditions for Die A
            int newFaceA = Math.min(dieA[i], 4);
            newDieA[i] = newFaceA;

            // No restrictions on Die B
            newDieB[i] = dieB[i];
        }

        return new TransformationResult(newDieA, newDieB);
    }
    

    
}
