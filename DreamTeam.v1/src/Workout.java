import java.util.ArrayList;

public class Workout{

    private String name;
    private ArrayList<String> exercises;
    private ArrayList<Integer> durations;
    private String comment;
    private String date;
    private String username;
    private int totalDuration;


    public Workout(String username, String name, ArrayList<String> exercise, ArrayList<Integer> durations, String comment, String date){
        this.name = name;
        this.username = username;
        this.exercises = exercise;
        this.durations = durations;
        this.comment = comment;
        this.date = date;
        this.totalDuration = 0;
        for(int duration: this.durations){
            this.totalDuration += duration;
        }
        return;
    }
    public String getName(){
        return this.name;
    }

    public ArrayList<String> getExercises(){
        return this.exercises;
    }

    public ArrayList<Integer> getDurations(){
        return this.durations;
    }

    public String getComment() {
        return this.comment;
    }

    public String getdate(){
        return this.date;
    }

    public String getUsername(){
        return this.username;
    }

    public int getTotalDuration() {
        return this.totalDuration;
    }


}

