package Codemaker;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Computer {
    private String generatedNumbers = "";
    private Set<Integer> possibleNumbers = (new HashSet<Integer>());
    private int blackPegsPrev = 0;
    private int whitePegsPrev = 0;
    private int blackPegs = 0;
    private int whitePegs = 0;
    private int safePegsum = 0;
    private String prevGuess = "0000";
    private String guess = "0000";
    private int dotIndex = 0;
    private int whiteIndex = 0;
    private int replaceIndex = 0;
    private char temp = '.';
    private boolean firstTimeFour = true;

    public char getTemp(){
        return temp;
    }

    public int getReplaceIndex(){
        return replaceIndex;
    }

    public int getWhiteIndex(){
        return whiteIndex;
    }

    public void setRemainder1(char remainder1) {
        this.remainder1 = remainder1;
    }

    public void setRemainder2(char remainder2) {
        this.remainder2 = remainder2;
    }

    public int getBlackPegs() {
        return blackPegs;
    }

    public void setBlackPegs(int blackPegs) {
        this.blackPegs = blackPegs;
    }

    public int getWhitePegs() {
        return whitePegs;
    }

    public void setWhitePegs(int whitePegs) {
        this.whitePegs = whitePegs;
    }

    private char remainder1;
    private char remainder2;
    private boolean remainder1Tried = false;
    private boolean remainder2Tried = false;

    public void setPrevGuess(String prevGuess){
        this.prevGuess = prevGuess;
    }

    public void setGuess(String guess){
        this.guess = guess;
    }

    public String firstGuess(){
        possibleNumbers.add(1);
        possibleNumbers.add(2);
        possibleNumbers.add(3);
        possibleNumbers.add(4);
        possibleNumbers.add(5);
        possibleNumbers.add(6);
        for (int i = 0; i < 4; i++) {
            int number = (int) (Math.random()*6) + 1;
            while (!possibleNumbers.contains(number)){
                number = (int) (Math.random()*6) + 1;
            }
            possibleNumbers.remove(number);
            generatedNumbers += number;
        }
        Iterator iterator = possibleNumbers.iterator();
        remainder1 =  iterator.next().toString().charAt(0);
        remainder2 =  iterator.next().toString().charAt(0);
        temp = remainder1;
        guess = generatedNumbers;
        return generatedNumbers;
    }

    public String makeNewGuess(String pegs) {
        countPegs(pegs);
        if (blackPegs + whitePegs < 4 && dotIndex < 4){
            return removeDots();
        } else{
            if (firstTimeFour){
                firstTimeFour = false;
                prevGuess = guess;
            }
            return removeWhite();
        }
    }

    private String removeWhite() {
        String newGuess = guess;
        if(blackPegs <= blackPegsPrev){
            newGuess = prevGuess;
            replaceIndex++;
        } else if(blackPegs > blackPegsPrev){
            prevGuess = guess;
            whiteIndex++;
            replaceIndex = 0;
        }
        if (replaceIndex == whiteIndex){
            replaceIndex++;
        }
        temp = newGuess.charAt(whiteIndex);
        char temp2 = newGuess.charAt(replaceIndex);
        newGuess = newGuess.replace(newGuess.charAt(whiteIndex), '0');
        newGuess = newGuess.replace(newGuess.charAt(replaceIndex), temp);
        newGuess = newGuess.replace('0',temp2);
        guess = newGuess;
        return newGuess;
    }

    private String removeDots() {
        String newGuess = guess;
        if(blackPegs + whitePegs < safePegsum || (blackPegs + whitePegs == safePegsum &&remainder1Tried&&remainder2Tried)){
            newGuess = prevGuess;
            dotIndex++;
            remainder1Tried = false;
            remainder2Tried = false;
        }else {
            prevGuess = guess;
            safePegsum = blackPegs + whitePegs;
            if (remainder2 == guess.charAt(dotIndex)){
                remainder2 = temp;
            } else {
                remainder1 = temp;
            }
        }
        if (dotIndex == 4){
            dotIndex--;
        }
        temp = newGuess.charAt(dotIndex);
        if (!remainder1Tried) {
            newGuess = newGuess.replace(newGuess.charAt(dotIndex), remainder1);
            remainder1Tried = true;
        } else {
            newGuess = newGuess.replace(newGuess.charAt(dotIndex), remainder2);
            remainder2Tried = true;
        }
        guess = newGuess;
        return newGuess;
    }

    public void countPegs(String pegs) {
        whitePegsPrev = whitePegs;
        blackPegsPrev = blackPegs;
        whitePegs = 0;
        blackPegs = 0;
        for (int i = 0; i < pegs.length(); i++){
            if(pegs.charAt(i) == 'b'){
                blackPegs++;
            } else if (pegs.charAt(i) == 'w'){
                whitePegs++;
            }
        }
    }
}
