import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayCreateProfileTest {
    @Test
    void initAndClose(){
        DisplayCreateProfile log = new DisplayCreateProfile();
        log.init();
        assertTrue(log.open);
        log.close();
        assertFalse(log.open);

    }
}
