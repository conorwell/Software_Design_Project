import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutTest {
    @Test
    void getAttributes() {
        ArrayList<String> Exercises = new ArrayList<>();
        Exercises.add("dips");
        Exercises.add("lunges");
        Exercises.add("squats");

        ArrayList<Integer> Durations = new ArrayList<>();
        Durations.add(15);
        Durations.add(30);
        Durations.add(45);
        Workout test = new Workout("test_workout",Exercises,Durations,"leg day","10/27/12");

        assertEquals(test.getName(),"test_workout");
        assertEquals(test.getComment(), "leg day");
        assertEquals(test.getExercises(), Exercises);
        assertEquals(test.getDurations(), Durations);
        assertEquals(test.getTotalDuration(), 90);
        assertEquals(test.getdate(), "10/27/12");
    }
}