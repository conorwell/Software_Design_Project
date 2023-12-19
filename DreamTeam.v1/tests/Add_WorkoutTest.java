import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Add_WorkoutTest {
    Add_Workout workout = new Add_Workout();

    @org.junit.jupiter.api.Test
    void addExercise() {
        ArrayList<String> exerc = new ArrayList<>();
        ArrayList<String> dur = new ArrayList<>();
        exerc.add("run");
        exerc.add("walk");
        dur.add("20");
        dur.add("30");
       Workout new_Work = workout.addExercise("Joe", "run", "blah", "Sat Dec 16 15:51:26 MST 2023", exerc, dur);


    }

    @org.junit.jupiter.api.Test
    void editExercise() {
        ArrayList<String> exerc = new ArrayList<>();
        ArrayList<String> dur = new ArrayList<>();
        exerc.add("run");
        exerc.add("walk");
        dur.add("20");
        dur.add("30");
        Workout new_Work = workout.addExercise("Joe", "run", "blah", "Sat Dec 16 15:51:26 MST 2023", exerc, dur);

    }
}