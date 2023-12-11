import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class workoutReccomenderTest {

    @Test
    void reccomend() {
        workoutReccomender wr = new workoutReccomender();
        String str = wr.reccomend("test");
        assertNotNull(str);
    }
}