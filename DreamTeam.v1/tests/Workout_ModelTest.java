import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Workout_ModelTest {

    @Test
    void addWorkouts_getWorkouts() {
        Date date = new Date();
        String[] exercises = new String[] {"bench","push","pull"};
        String[] durations = new String[] {"10", "50","40"};
        Workout_Model model = new Workout_Model();
        model.addWorkouts("conorwell", "test", "felt good today", "100", date, exercises, durations);
        model.addWorkouts("zebman", "none", "N/A", "100", date, exercises, durations);
        List<List<String>>workouts = model.getWorkouts();
        assertEquals(workouts.get(0).get(0), "conorwell");
        assertEquals(workouts.get(0).get(1), "test");
        assertEquals(workouts.get(0).get(2), "felt good today");
        assertEquals(workouts.get(0).get(3), "100");
        assertEquals(workouts.get(0).get(4), String.valueOf(date));
        assertEquals(workouts.get(0).get(5), "bench");
        assertEquals(workouts.get(0).get(6), "10");
        assertEquals(workouts.get(0).get(7), "push");
        assertEquals(workouts.get(0).get(8), "50");
        assertEquals(workouts.get(0).get(9), "pull");
        assertEquals(workouts.get(0).get(10), "40");

        assertEquals(workouts.get(1).get(0), "zebman");
        assertEquals(workouts.get(1).get(1), "none");
        assertEquals(workouts.get(1).get(2), "N/A");
        assertEquals(workouts.get(1).get(3), "100");
        assertEquals(workouts.get(1).get(4), String.valueOf(date));
        assertEquals(workouts.get(1).get(5), "bench");
        assertEquals(workouts.get(1).get(6), "10");
        assertEquals(workouts.get(1).get(7), "push");
        assertEquals(workouts.get(1).get(8), "50");
        assertEquals(workouts.get(1).get(9), "pull");
        assertEquals(workouts.get(1).get(10), "40");
    }

    @Test
    void editWorkout() throws ParseException {
        Date date = new Date();
        String[] exercises = new String[] {"bench","push","pull"};
        String[] durations = new String[] {"10", "50","40"};
        Workout_Model model = new Workout_Model();
        model.addWorkouts("conorwell", "test", "felt good today", "100", date, exercises, durations);
        model.editWorkout("conorwell", "testing", "felt bad today", "100", date, exercises, durations);

        List<List<String>>workouts = model.getWorkouts();
        assertEquals(workouts.get(0).get(0), "conorwell");
        assertEquals(workouts.get(0).get(1), "testing");
        assertEquals(workouts.get(0).get(2), "felt bad today");
        assertEquals(workouts.get(0).get(3), "100");
        assertEquals(workouts.get(0).get(4), String.valueOf(date));
        assertEquals(workouts.get(0).get(5), "bench");
        assertEquals(workouts.get(0).get(6), "10");
        assertEquals(workouts.get(0).get(7), "push");
        assertEquals(workouts.get(0).get(8), "50");
        assertEquals(workouts.get(0).get(9), "pull");
        assertEquals(workouts.get(0).get(10), "40");
    }


    @Test
    void getWorkouts() {
        Date date = new Date();
        String[] exercises = new String[] {"bench","push","pull"};
        String[] durations = new String[] {"10", "50","40"};
        Workout_Model model = new Workout_Model();
        model.addWorkouts("conorwell", "test", "felt good today", "100", date, exercises, durations);
        model.addWorkouts("zebman", "none", "N/A", "100", date, exercises, durations);
        List<List<String>>workouts = model.getWorkouts("conorwell");
        assertEquals(workouts.get(0).get(0), "conorwell");
        assertEquals(workouts.get(0).get(1), "test");
        assertEquals(workouts.get(0).get(2), "felt good today");
        assertEquals(workouts.get(0).get(3), "100");
        assertEquals(workouts.get(0).get(4), String.valueOf(date));
        assertEquals(workouts.get(0).get(5), "bench");
        assertEquals(workouts.get(0).get(6), "10");
        assertEquals(workouts.get(0).get(7), "push");
        assertEquals(workouts.get(0).get(8), "50");
        assertEquals(workouts.get(0).get(9), "pull");
        assertEquals(workouts.get(0).get(10), "40");
        assertEquals(workouts.size(), 1);
    }
}