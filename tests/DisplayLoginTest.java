import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class DisplayLoginTest {
    @Test
    void initAndClose(){
        DisplayLogin log = new DisplayLogin();
        log.init();
        assertTrue(log.open);
        log.close();
        assertFalse(log.open);

    }
}
