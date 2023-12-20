import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutBuilder_ConcreteTest {

    @Test
    void workoutBuilder() {
        WorkoutBuilder wm = new WorkoutBuilder_Concrete();

        ArrayList<String> exerc = new ArrayList<>();
        ArrayList<String> dur = new ArrayList<>();
        exerc.add("run");
        exerc.add("walk");
        dur.add("20");
        dur.add("30");
        String user = "";
        String name = "";
        String com = "";
        String date = "";
        wm.workoutBuilder(user, name, exerc, dur, com, date);

    }
}