

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

    public void addWorkouts(String username, String workoutName, String comment, String totalDuration, String date, ArrayList<String> exercises, ArrayList<String> durations) {
        try {Statement addStatement = networkDriver.network.createStatement();
            addStatement.executeUpdate("insert into "+username+"workouts (name,comment,total_duration,date) values " +
                    "('"+workoutName+"','"+comment+"','"+Integer.parseInt(totalDuration)+"','"+date+"');");
            for (int i = 0; i < exercises.size(); i++) {
                addStatement.executeUpdate("insert into "+username+"workouts (name,exercise,exercise_duration) values" +
                        " ('"+workoutName+"','"+exercises.get(i)+"','"+Integer.parseInt(durations.get(i))+"');");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editWorkout(String newUsername, String newWOName, String newComment, String newTotal, String date, String[] newExercises, String[] newDurations) throws ParseException {
        List<List<String>> workouts = new ArrayList<>();
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).get(4).equals(String.valueOf(date))) {
                workouts.get(i).set(0, newUsername);
                workouts.get(i).set(1, newWOName);
                workouts.get(i).set(2, newComment);
                workouts.get(i).set(3, newTotal);
                for (int j = 5; j < (workouts.get(i).size() - 5); j++) {
                    workouts.get(i).set(j, newExercises[j - 5]);
                    workouts.get(i).set(j + 1, newDurations[j - 5]);
                }
            }
        }
        for (int i = 0; i < workouts.size(); i++) {
            String[] exercises = new String[(workouts.get(i).size() - 5) / 2];
            String[] durations = new String[(workouts.get(i).size() - 5) / 2];
            for (int j = 5; j < (workouts.get(i).size() - 5); j++) {
                exercises[j - 5] = workouts.get(i).get(j);
                durations[j - 5] = workouts.get(i).get(j + 1);
            }
        }
        File workoutFile = new File("workouts.csv");
        try {
            FileWriter workoutWriter = new FileWriter(workoutFile);
            if (workouts.size() > 0) {
                for (int i = 0; i < workouts.size(); i++) {
                    for (int j = 0; j < workouts.get(i).size(); j++) {
                        //write existing workouts to csv file
                        workoutWriter.write(workouts.get(i).get(j) + ",");
                    }
                    workoutWriter.write("\n");
                }
            }
            workoutWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
