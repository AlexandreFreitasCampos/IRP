package br.com.claro;

import java.util.ArrayList;
import java.util.List;

public class FortuneOxProbability {

    // Definição dos símbolos no reel
    static String[] symbols = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    static int reelSymbols = symbols.length;
    static int numReels = 3;

    public static void main(String[] args) {
        // Gerar todas as combinações possíveis de símbolos nos reels
        List<String[]> allCombinations = generateAllCombinations(symbols, numReels);

        // Calcular número de combinações vencedoras
        int numWinningCombinations = 0;
        for (String[] combination : allCombinations) {
            if (isWinningCombination(combination)) {
                numWinningCombinations++;
            }
        }

        // Calcular a probabilidade
        int totalCombinations = (int) Math.pow(reelSymbols, numReels);
        double probabilityOfWinning = (double) numWinningCombinations / totalCombinations;

        // Exibir resultados
        System.out.println("Total de combinações possíveis: " + totalCombinations);
        System.out.println("Número de combinações vencedoras: " + numWinningCombinations);
        System.out.printf("Probabilidade de ganhar: %.4f (%.2f%%)\n", probabilityOfWinning, probabilityOfWinning * 100);
    }

    // Função para verificar se a combinação é vencedora
    public static boolean isWinningCombination(String[] combination) {
        for (int i = 1; i < combination.length; i++) {
            if (!combination[i].equals(combination[i - 1])) {
                return false;
            }
        }
        return true;
    }

    // Função para gerar todas as combinações possíveis de símbolos nos reels
    public static List<String[]> generateAllCombinations(String[] symbols, int numReels) {
        List<String[]> combinations = new ArrayList<>();
        generateAllCombinationsRecursive(combinations, new String[numReels], symbols, 0);
        return combinations;
    }

    // Função recursiva para gerar todas as combinações possíveis
    public static void generateAllCombinationsRecursive(List<String[]> combinations, String[] current, String[] symbols, int index) {
        if (index == current.length) {
            combinations.add(current.clone());
            return;
        }

        for (String symbol : symbols) {
            current[index] = symbol;
            generateAllCombinationsRecursive(combinations, current, symbols, index + 1);
        }
    }
}
