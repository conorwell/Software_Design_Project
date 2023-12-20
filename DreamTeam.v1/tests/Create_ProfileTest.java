import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Create_ProfileTest {
    @Test
    void create(){
        Create_Profile c = new Create_Profile();
        c.create();
        assertTrue(c.f.open);
    }
}
