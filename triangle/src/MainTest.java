import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void isAvaliableTrueIntArgs(){
        assertTrue(Main.isAvaliable(1,1,1));
    }

    @Test
    public void isAvaliableFalseIntArgs(){
        assertFalse(Main.isAvaliable(1,2,3));
    }

    @Test
    public void isAvaliableZeroArgs(){
        assertFalse(Main.isAvaliable(0,0,0));
    }

    @Test
    public void isAvaliableNegativeArgs(){
        assertFalse(Main.isAvaliable(1,-1,1));
    }

    @Test
    public void isAvaliableString(){
        assertFalse(Main.isAvaliable(1,1, Double.parseDouble("3")));
    }
    @Test
    public void isAvaliable8(){
        assertTrue(Main.isAvaliable(1,1, Double.parseDouble("1")));
    }

    @Test
    public void isAvaliableTrueDoubleArgs(){
        assertTrue(Main.isAvaliable(0.5,0.6,0.7));
    }

    @Test
    public void isAvaliableFalseDoubleArgs(){
        assertFalse(Main.isAvaliable(0.4,0.1,0.7));
    }

    @Test
    public void isAvaliablePeriodTrue(){
        assertFalse(Main.isAvaliable(1/3,1,1));
    }

    @Test
    public void isAvaliableSQRT(){
        assertFalse(Main.isAvaliable(Math.sqrt(-1),1,1));
    }
}