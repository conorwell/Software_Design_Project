import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Add_Workout_GUITest {

    @Test
    void add_Workout_GUI() {
        Add_Workout_GUI addGUI = new Add_Workout_GUI();
        addGUI.Add_Workout_GUI("BWah");
        assertTrue(addGUI.f.isVisible());
    }
}