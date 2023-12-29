import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Edit_Workout_GUITest {

    @Test
    void edit_Workout_GUI_Run() {
        Edit_Workout_GUI e = new Edit_Workout_GUI();
        e.Edit_Workout_GUI_Run("", ",","","");
        assertTrue(e.fred.isVisible());
        e.fred.dispose();
        assertFalse(e.fred.isVisible());

    }
}