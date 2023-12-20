import java.util.ArrayList;

 abstract class WorkoutBuilder {
     abstract Workout workoutBuilder(String user, String name, ArrayList<String> exer, ArrayList<String> dur, String com, String date);
}
