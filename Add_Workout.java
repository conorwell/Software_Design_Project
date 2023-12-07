import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Add_Workout {
    private ArrayList<String> exercises;
    private ArrayList<String> durations;
    private String username;
    private String totalDuration;
    private String workoutName;
    private String workoutComment;
    private String date;


    public ArrayList<String> addExercise(String user, String wrkName, String comment, String date, ArrayList<String> exerc, ArrayList<String> exerDur) {
        ArrayList<String> new_exercise = new ArrayList<String>();
        this.username = user;
        this.durations = exerDur;
        this.exercises = exerc;
        this.workoutName = wrkName;
        this.workoutComment = comment;
        this.date = date;
        int total = 0;

        for(String s : exerDur){
            int temp = Integer.parseInt(s);
            total = total + temp;
        }

        this.totalDuration = String.valueOf(total);

        new_exercise.add(username);
        new_exercise.add(totalDuration);
        new_exercise.add(workoutComment);
        new_exercise.add(date);


        for(int i =0; i<exercises.size(); i++){
            new_exercise.add(exercises.get(i));
            new_exercise.add(durations.get(i));
        }

        for(String s: new_exercise){
            System.out.println(s);
        }
        Workout_Model mod = new Workout_Model();
        mod.addWorkouts(username, workoutName, workoutComment, totalDuration, date, exercises, durations);
        return new_exercise;
    }
}