package com.Doomed.Dice.repositories;

import java.util.ArrayList;
import java.util.List;

import com.Doomed.Dice.entity.DiceEntity;

public class InMemoryDiceRepository implements DiceRepository {

    private final List<DiceEntity> diceEntities = new ArrayList<>();

    @Override
    public List<DiceEntity> getAllDice() {
        return new ArrayList<>(diceEntities);
    }

    @Override
    public DiceEntity saveDice(DiceEntity dice) {
        diceEntities.add(dice);
        return dice;
    }
}