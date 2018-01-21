import Codemaker.Computer;
import org.junit.Test;
import static org.junit.Assert.*;

public class CodemakerComputerTest {

    @Test
    public void testCountPegs4White(){
        Computer computer = new Computer();
        computer.countPegs("wwww");
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
}
