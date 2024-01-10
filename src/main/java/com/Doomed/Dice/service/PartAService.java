package com.Doomed.Dice.service;

public class PartAService {

    private int numberOfFaces1;
    private int numberOfFaces2;

    public PartAService(int numberOfFaces1, int numberOfFaces2) {
        this.numberOfFaces1 = numberOfFaces1;
        this.numberOfFaces2 = numberOfFaces2;
    }

    public int calculateTotalCombinations() {
        return numberOfFaces1 * numberOfFaces2;
    }

    public int[][] calculateDistribution() {
        int[][] distribution = new int[numberOfFaces1][numberOfFaces2];

        for (int i = 0; i < numberOfFaces1; i++) {
            for (int j = 0; j < numberOfFaces2; j++) {
                distribution[i][j] = i + 1 + j + 1; // Sum of faces on Die A and Die B
            }
        }

        return distribution;
    }

    public void printDistribution(int[][] distribution) {
        for (int i = 0; i < numberOfFaces1; i++) {
            for (int j = 0; j < numberOfFaces2; j++) {
                System.out.print(distribution[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printProbabilities() {
        int totalCombinations = calculateTotalCombinations();

        for (int sum = 2; sum <= numberOfFaces1 + numberOfFaces2; sum++) {
            int count = 0;
            int[][] distribution = calculateDistribution();

            for (int i = 0; i < numberOfFaces1; i++) {
                for (int j = 0; j < numberOfFaces2; j++) {
                    if (distribution[i][j] == sum) {
                        count++;
                    }
                }
            }

            double probability = (double) count / totalCombinations;
            System.out.println("P(Sum = " + sum + ") = " + count + "/" + totalCombinations + " = " + probability);
        }
    }
    

    
}