import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Edit_Workout_ControllerTest {

    @Test
    void editListen() {
        Edit_Workout_Controller e = new Edit_Workout_Controller();
        String s="";
        String st="";
        String str ="";
        String stri = "";
        e.editListen(s,st,str,stri);
        assertTrue(e.edit.fred.isVisible());


    }
}