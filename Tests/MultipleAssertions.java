import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleAssertions {
    @Test
    void multipleAssertions() {
        assertFalse(false);
        assertNotEquals(0, 999);
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(500);
        });
        assertDoesNotThrow(()-> {
            System.out.println("bob");
        });
        assertNotNull(new Bank());
        assertTrue(true);
        assertNull(null);
        assertArrayEquals(new int[]{}, new int[]{});
    }
}
