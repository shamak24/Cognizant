import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Calculator;

public class AssertionsTest {
@Test
    public void testAssertions() {

        Calculator calc = new Calculator();

        // Assert Equals
        assertEquals(10, calc.add(4, 6));

        // Assert True
        assertTrue(calc.isPositive(5));

        // Assert False
        assertFalse(calc.isPositive(-5));

        // Assert Null
        assertNull(calc.getMessage());

        // Assert Not Null
        assertNotNull(calc.createObject());
    }
}
