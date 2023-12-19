

import Network.NetworkDriver;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.util.*;


public final class Workout_Model {
    public static final Workout_Model wm = new Workout_Model();
    public static Workout_Model getInstance(){
        return wm;
    }
    NetworkDriver networkDriver = new NetworkDriver();
    public void createWorkoutsList(String username) {    //to be run when an account is created
        try {
            Statement createStatement = networkDriver.network.createStatement();
            createStatement.executeUpdate("create table "+username+"workouts (" +
                    "name varchar(50)," +
                    "comment varchar(150)," +
                    "total_duration int," +
                    "date varchar(50)," +
                    "exercise varchar(50)," +
                    "exercise_duration int" +
                    ");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public ArrayList<ArrayList<String>> getWorkouts(String username) {
        //create ArrayList of workouts
        ArrayList<ArrayList<String>> userWorkouts = new ArrayList<>();
        try {
            Statement getWorkoutStatement = networkDriver.network.createStatement();
            ResultSet workoutSet = getWorkoutStatement.executeQuery("select * from "+username+"workouts where exercise is null;");
            while (workoutSet.next()) {
                ArrayList<String> workout = new ArrayList<>();
                workout.add(workoutSet.getString("name"));
                workout.add(workoutSet.getString("comment"));
                workout.add(workoutSet.getString("total_duration"));
                workout.add(workoutSet.getString("date"));
                Statement getExerciseStatement = networkDriver.network.createStatement();
                ResultSet exerciseSet = getExerciseStatement.executeQuery("select * from "+username+"workouts where exercise is not null and name='"+workout.get(0)+"';");
                while (exerciseSet.next()) {
                    workout.add(exerciseSet.getString("exercise"));
                    workout.add(exerciseSet.getString("exercise_duration"));
                }
                userWorkouts.add(workout);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return userWorkouts;
    }

    public void addWorkouts(Workout workout) {
        String username = workout.getUsername();
        String comment = workout.getComment();
        String workoutName = workout.getName();
        int totalDuration = workout.getTotalDuration();
        String date = workout.getdate();
        ArrayList<String> exercises = workout.getExercises();
        ArrayList<Integer> durations = workout.getDurations();
        try {Statement addStatement = networkDriver.network.createStatement();
            addStatement.executeUpdate("insert into "+username+"workouts (name,comment,total_duration,date) values " +
                    "('"+workoutName+"','"+comment+"','"+totalDuration+"','"+date+"');");
            for (int i = 0; i < exercises.size(); i++) {
                addStatement.executeUpdate("insert into "+username+"workouts (name,exercise,exercise_duration) values" +
                        " ('"+workoutName+"','"+exercises.get(i)+"','"+durations.get(i)+"');");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editWorkout(Workout workout) throws ParseException {
        String username = workout.getUsername();
        String date = workout.getdate();
        try{Statement addStatement = networkDriver.network.createStatement();
            addStatement.executeUpdate("delete from "+username+"workouts where date = '"+date+"'");
            Workout_Model model = Workout_Model.getInstance();
            model.addWorkouts(workout);
        }catch(Exception e){

        }
    }

}
