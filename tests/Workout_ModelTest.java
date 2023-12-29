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
        Workout w1 = new Workout("testcase5","w1",exercises,durations,"felt good today",date);

        model.createWorkoutsList("testcase5");
        model.addWorkouts(w1);

        ArrayList<ArrayList<String>> workouts = model.getWorkouts("testcase5");
        assertEquals(workouts.get(0).get(0), "w1");
        assertEquals(workouts.get(0).get(1), "felt good today");
        assertEquals(workouts.get(0).get(2), "100");
        assertEquals(workouts.get(0).get(3), "10/27/14");
        assertEquals(workouts.get(0).get(4), "bench");
        assertEquals(workouts.get(0).get(5), "10");
        assertEquals(workouts.get(0).get(6), "push");
        assertEquals(workouts.get(0).get(7), "50");
        assertEquals(workouts.get(0).get(8), "pull");
        assertEquals(workouts.get(0).get(9), "40");
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
        Workout w = new Workout("editTester1","w",exercises,durations,"felt good today",date);
        Workout_Model model = Workout_Model.getInstance();
        model.createWorkoutsList("editTester1");
        model.addWorkouts(w);
        Workout wEdit = new Workout("editTester1","wEdit",exercises,durations,"felt bad today", date);
        model.editWorkout(wEdit);

        ArrayList<ArrayList<String>> workouts = model.getWorkouts("editTester1");
        assertEquals(workouts.get(0).get(1), "felt bad today");
        assertEquals(workouts.get(0).get(2), "100");
        assertEquals(workouts.get(0).get(3), "10/27/20");
        assertEquals(workouts.get(0).get(4), "bench");
        assertEquals(workouts.get(0).get(5), "10");
        assertEquals(workouts.get(0).get(6), "push");
        assertEquals(workouts.get(0).get(7), "50");
        assertEquals(workouts.get(0).get(8), "pull");
        assertEquals(workouts.get(0).get(9), "40");
    }



}