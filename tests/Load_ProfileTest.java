import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Load_ProfileTest {
    @Test
    void login(){
        Load_Profile loader = new Load_Profile();
        loader.login();
        assertTrue(loader.f.open);

    }
}
