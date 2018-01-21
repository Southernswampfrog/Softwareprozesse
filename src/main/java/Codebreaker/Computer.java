package Codebreaker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private ArrayList<Integer> generatedNumbers = new ArrayList<Integer>();
    private Set<Integer>possibleNumbers = (new HashSet<Integer>());

    public ArrayList<Integer> getGeneratedNumbers(){
        return generatedNumbers;
    }

    public ArrayList<Integer> generateNumbers(){
        possibleNumbers.add(1);
        possibleNumbers.add(2);
        possibleNumbers.add(3);
        possibleNumbers.add(4);
        generatedNumbers.addAll(possibleNumbers);
        possibleNumbers.add(5);
        possibleNumbers.add(6);
        for (int i = 0; i < 4; i++) {
            int number = (int) (Math.random()*6) + 1;
            while (!possibleNumbers.contains(number)){
                number = (int) (Math.random()*6) + 1;
            }
            possibleNumbers.remove(number);
            generatedNumbers.set(i, number);
        }
        return generatedNumbers;
    }

    public String generatePegs(String newGuess, int tries) {
        String pegString = "";
        int [] guess = new int[newGuess.length()];
        for (int n = 0; n < newGuess.length(); n++){
            guess[n] = Character.getNumericValue(newGuess.charAt(n));
        }

        for (int i = 0; i < guess.length; i++) {
            if(guess[i] == generatedNumbers.get(i)){
                pegString += "b";
            } else if (generatedNumbers.contains(guess[i])){
                pegString += "w";
            } else {
                pegString += ".";
            }
        }
        System.out.println(tries + ". | " + newGuess + " | " + pegString);
        return pegString;
    }
}
