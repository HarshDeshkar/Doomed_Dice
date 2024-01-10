package com.Doomed.Dice.repositories;

import java.util.List;

import com.Doomed.Dice.entity.DiceEntity;

public interface DiceRepository {
    List<DiceEntity> getAllDice();

    DiceEntity saveDice(DiceEntity dice);
}
