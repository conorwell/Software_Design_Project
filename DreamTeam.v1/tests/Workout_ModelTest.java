import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Workout_ModelTest {

    @Test
    void addWorkouts_getWorkouts() {
        String date = "10/27/14";
        ArrayList<String> exercises = new ArrayList<String>();
        ArrayList<Integer> durations = new ArrayList<Integer>();
        exercises.add("bench");
        exercises.add("push");
        exercises.add("pull");
        durations.add(10);
        durations.add(50);
        durations.add(40);
        Workout_Model model = Workout_Model.getInstance();
        Workout w1 = new Workout("conorwell","test",exercises,durations,"felt good today",date);
        Workout w2 = new Workout("zebman","none",exercises,durations,"N/A",date);
        model.addWorkouts(w1);
        model.addWorkouts(w2);
        ArrayList<ArrayList<String>> workouts = model.getWorkouts("conorwell");
        assertEquals(workouts.get(0).get(0), "conorwell");
        assertEquals(workouts.get(0).get(1), "test");
        assertEquals(workouts.get(0).get(2), "felt good today");
        assertEquals(workouts.get(0).get(3), "100");
        assertEquals(workouts.get(0).get(4), "10/27/14");
        assertEquals(workouts.get(0).get(5), "bench");
        assertEquals(workouts.get(0).get(6), "10");
        assertEquals(workouts.get(0).get(7), "push");
        assertEquals(workouts.get(0).get(8), "50");
        assertEquals(workouts.get(0).get(9), "pull");
        assertEquals(workouts.get(0).get(10), "40");

        ArrayList<ArrayList<String>> workouts2 = model.getWorkouts("zebman");
        assertEquals(workouts2.get(0).get(0), "zebman");
        assertEquals(workouts2.get(0).get(1), "none");
        assertEquals(workouts2.get(0).get(2), "N/A");
        assertEquals(workouts2.get(0).get(3), "100");
        assertEquals(workouts2.get(0).get(4), String.valueOf(date));
        assertEquals(workouts2.get(0).get(5), "bench");
        assertEquals(workouts2.get(0).get(6), "10");
        assertEquals(workouts2.get(0).get(7), "push");
        assertEquals(workouts2.get(0).get(8), "50");
        assertEquals(workouts2.get(0).get(9), "pull");
        assertEquals(workouts2.get(0).get(10), "40");
    }

    @Test
    void singleton(){
        Workout_Model wm = Workout_Model.getInstance();
        assertEquals(wm, Workout_Model.getInstance());
    }


    @Test
    void editWorkout() throws ParseException {
        String date = "10/27/20";
        ArrayList<String> exercises = new ArrayList<String>();
        ArrayList<Integer> durations = new ArrayList<Integer>();
        exercises.add("bench");
        exercises.add("push");
        exercises.add("pull");
        durations.add(10);
        durations.add(50);
        durations.add(40);
        Workout w = new Workout("conorwell","test",exercises,durations,"felt good today",date);
        Workout_Model model = Workout_Model.getInstance();
        model.addWorkouts(w);
        Workout wEdit = new Workout("conorwell","testing",exercises,durations,"felt bad today", date);
        model.editWorkout(wEdit);

        ArrayList<ArrayList<String>> workouts = model.getWorkouts("conorwell");
        assertEquals(workouts.get(0).get(0), "conorwell");
        assertEquals(workouts.get(0).get(1), "testing");
        assertEquals(workouts.get(0).get(2), "felt bad today");
        assertEquals(workouts.get(0).get(3), "100");
        assertEquals(workouts.get(0).get(4), "10/27/20");
        assertEquals(workouts.get(0).get(5), "bench");
        assertEquals(workouts.get(0).get(6), "10");
        assertEquals(workouts.get(0).get(7), "push");
        assertEquals(workouts.get(0).get(8), "50");
        assertEquals(workouts.get(0).get(9), "pull");
        assertEquals(workouts.get(0).get(10), "40");
    }



}