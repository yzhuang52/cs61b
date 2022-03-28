import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void testFilk(){
        assertTrue(Flik.isSameNumber(1 ,1));
        assertFalse(Flik.isSameNumber(1,2));
        assertTrue(Flik.isSameNumber(129, 129));
        assertTrue(Flik.isSameNumber(128, 128));

    }
}
