package Codebreaker;

import java.util.Scanner;

public class Main {

    public static void main (String args[]){
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Generating new combination...");
        computer.generateNumbers();

        int tries = 1;
        boolean guessedWrong = true;
        String pegs = "....";
        while (!pegs.equals("bbbb")){
            System.out.println("Please input your guess #" + tries);
            String newGuess = scanner.next();
            pegs = computer.generatePegs(newGuess, tries);
            tries++;
        }
        System.out.println("Congratulations! You found the combination after " + (tries-1) + " tries!");
    }
}
