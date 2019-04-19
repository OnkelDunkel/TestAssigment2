import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleAssertions {
    @Test
    @DisplayName("8 assertions (renamed)")
    void multipleAssertions() {
        assertNotEquals(0, 999);
        assertTrue(true);
        assertFalse(false);
        assertTimeout(Duration.ofMillis(1000), () -> {
            Thread.sleep(500);
        });
        assertDoesNotThrow(()-> {
            System.out.println("bob");
        });
        assertNull(null);
        assertNotNull(new Bank());
        assertArrayEquals(new int[]{}, new int[]{});


        assertEquals("bob", () -> {
            String s = "bob";
            System.out.println(s);
            return s;
        });


        // Below should fail
//        assertTimeout(Duration.ofMillis(5000), () -> {
//            Thread.sleep(8000);
//        });
    }
}
