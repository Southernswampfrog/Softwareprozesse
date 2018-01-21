package Codemaker;

import java.util.ArrayList;

public class Computer {
    private ArrayList<String> possibleCodes = new ArrayList();
    private String guess = "0000";

    public ArrayList<String> getPossibleCodes() {
        return possibleCodes;
    }

    public String firstGuess(){
        generatePossibleCodes();
        guess = "1234";
        return guess;
    }

    public String makeNewGuess(String pegs) {
        int blackPegs = countBlackPegs(pegs);
        int whitePegs = countWhitePegs(pegs);
        removeInconsistentCodes(blackPegs, whitePegs);
        guess = possibleCodes.get((int) (Math.random()*possibleCodes.size()));
        return guess;
    }

    private void removeInconsistentCodes(int blackPegs, int whitePegs) {
        ArrayList<String> newPossibles = new ArrayList<String>();
        for (String possibleCode : possibleCodes) {
            String pegs = generatePegs(guess, possibleCode);
            if (countBlackPegs(pegs) == blackPegs && countWhitePegs(pegs) == whitePegs){
                newPossibles.add(possibleCode);
            }
        }
        possibleCodes = newPossibles;
    }


    public int countBlackPegs(String pegs) {
        int bpegs = 0;
        for (int i = 0; i < pegs.length(); i++){
            if(pegs.charAt(i) == 'b') {
                bpegs++;
            }
        }
        return bpegs;
    }

    public int countWhitePegs(String pegs) {
        int wpegs = 0;
        for (int i = 0; i < pegs.length(); i++){
            if (pegs.charAt(i) == 'w'){
                wpegs++;
            }
        }
        return wpegs;
    }


    public void generatePossibleCodes(){
        permutation("", "1234");
        permutation("", "5234");
        permutation("", "6234");
        permutation("", "1534");
        permutation("", "1634");
        permutation("", "1254");
        permutation("", "1264");
        permutation("", "1235");
        permutation("", "1236");
        permutation("", "1256");
        permutation("", "1536");
        permutation("", "5236");
        permutation("", "5264");
        permutation("", "5634");
        permutation("", "1564");
    }

    private void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            if (!possibleCodes.contains(prefix)) {
                possibleCodes.add(prefix);
            }
        }
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public String generatePegs(String newGuess, String compareGuess) {
        String pegString = "";
        ArrayList<Integer> guess = new ArrayList<Integer>();
        for (int n = 0; n < newGuess.length(); n++){
            guess.add(Character.getNumericValue(newGuess.charAt(n)));
        }
        ArrayList<Integer> compGuess = new ArrayList<Integer>();
        for (int l = 0; l < compareGuess.length(); l++){
            compGuess.add(Character.getNumericValue(compareGuess.charAt(l)));
        }

        for (int i = 0; i < guess.size(); i++) {
            if(guess.get(i).equals(compGuess.get(i))){
                pegString += "b";
            } else if (compGuess.contains(guess.get(i))){
                pegString += "w";
            } else {
                pegString += ".";
            }
        }
        return pegString;
    }

}
