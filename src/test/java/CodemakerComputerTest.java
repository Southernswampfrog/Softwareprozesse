import Codemaker.Computer;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CodemakerComputerTest {

    @Test
    public void testCountPegs4White(){
        Computer computer = new Computer();
        //computer.countPegs("wwww");
        assertEquals(computer.getWhitePegs(), 4);
        assertEquals(computer.getBlackPegs(), 0);
    }
    @Test
    public void testNewGuessWithAllWhite(){
        Computer computer = new Computer();
        computer.setGuess("1234");
        computer.setPrevGuess("1235");
    }

    @Test
    public void testNewGuessWithOneHole(){
        Computer computer = new Computer();
        computer.setGuess("1234");
        computer.setPrevGuess("1235");
        String guess = computer.makeNewGuess("wwww");
        assertEquals(computer.getTemp(), '1');
        assertEquals(computer.getReplaceIndex(), 1);
        assertEquals(computer.getWhiteIndex(), 0);
        assertEquals(guess, "2134");
    }

    @Test
    public void testNewGuessWithTwoHoles(){
        Computer computer = new Computer();
        computer.setGuess("1234");
        computer.setPrevGuess("1235");
    }

    @Test
    public void testPermutation(){
        Computer computer = new Computer();
        computer.generatePossibleCodes();
        ArrayList possibleCodes = computer.getPossibleCodes();
        assertEquals(possibleCodes.size(), 360);
    }

    @Test
    public void testGeneratePegs(){
        Computer computer = new Computer();
        String pegs = computer.generatePegs("5146","3145");
        assertEquals(pegs, "wwww");
    }
}
