package Codemaker;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main (String args[]) {
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please evaluate my Guess");
        String guess = computer.firstGuess();
        System.out.println(guess);
        String pegs = scanner.next();
        while(!pegs.equals("bbbb")){
            System.out.println("Please evaluate my Guess");
            guess = computer.makeNewGuess(pegs);
            System.out.println(guess);
            pegs = scanner.next();
        }
        System.out.println("Yay, I did it! So your code is " + guess + "!");
    }

}
