package com.Doomed.Dice;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.Doomed.Dice.entity.DiceEntity;
import com.Doomed.Dice.entity.TransformationResult;
import com.Doomed.Dice.repositories.DiceRepository;
import com.Doomed.Dice.repositories.InMemoryDiceRepository;
import com.Doomed.Dice.service.PartAService;
import com.Doomed.Dice.service.PartBService;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part A - Input
        System.out.print("Enter the number of faces for Die A (Part A): ");
        int numberOfFacesA = scanner.nextInt();

        System.out.print("Enter the number of faces for Die B (Part A): ");
        int numberOfFacesB = scanner.nextInt();

        PartAService partAService = new PartAService(numberOfFacesA, numberOfFacesB);
		DiceRepository diceRepository = new InMemoryDiceRepository();
		PartBService partBService = new PartBService(diceRepository);


        // Part A - Operations
        int totalCombinationsA = partAService.calculateTotalCombinations();
        System.out.println("Total Combinations for Part A: " + totalCombinationsA);

        int[][] distributionA = partAService.calculateDistribution();
        partAService.printDistribution(distributionA);

        partAService.printProbabilities();

         // Part B: Undoom the dice

        List<DiceEntity> allDice = diceRepository.getAllDice();
        System.out.println("All Dice: " + allDice);

        DiceEntity savedDice = diceRepository.saveDice(new DiceEntity(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println("Saved Dice: " + savedDice.getFaces());

        TransformationResult transformationResult = partBService.undoom_dice(
            new int[]{1, 2, 3, 4, 5, 6},
            new int[]{1, 2, 3, 4, 5, 6}
        );
        System.out.println("Transformed Die A: " + arrayToString(transformationResult.getNewDieA()));
        System.out.println("Transformed Die B: " + arrayToString(transformationResult.getNewDieB()));
    }

    private static String arrayToString(int[] array) {
        return "[" + String.join(", ", Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new)) + "]";
    }
}

