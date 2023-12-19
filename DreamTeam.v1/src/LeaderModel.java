import Network.NetworkDriver;

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class LeaderModel {
    NetworkDriver networkDriver = new NetworkDriver();
    public ArrayList<String> getFriends(String u){
        ArrayList<String> friendsList = new ArrayList<>();
        try {
            Statement getStatement = networkDriver.network.createStatement();
            ResultSet userSet = getStatement.executeQuery("select * from "+u+"friends");
            while (userSet.next()) {
                String friend = userSet.getString("username");
                friendsList.add(friend);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(friendsList);
        return friendsList;
    }



    public ArrayList<ArrayList<String>> getOwnWorkouts(String u,LeaderBoardGUI g){
        DefaultTableModel defTab = new DefaultTableModel(){ //creating table model
            @Override
            public boolean isCellEditable(int row, int column) { //declaring table is not editable
                //all cells false
                return false;
            }
        };


        ArrayList<String> friends = getFriends(u);


        ArrayList<ArrayList<String>> userWorkouts = new ArrayList<>();
        try {
            Statement getWorkoutStatement = networkDriver.network.createStatement();
            ResultSet workoutSet = getWorkoutStatement.executeQuery("select * from "+u+"workouts where exercise is null;");
            while (workoutSet.next()) {
                ArrayList<String> workout = new ArrayList<>();
                workout.add(workoutSet.getString("name"));
                workout.add(workoutSet.getString("comment"));
                workout.add(workoutSet.getString("total_duration"));
                workout.add(workoutSet.getString("date"));
                Statement getExerciseStatement = networkDriver.network.createStatement();
                ResultSet exerciseSet = getExerciseStatement.executeQuery("select * from "+u+"workouts where exercise is not null and name='"+workout.get(0)+"';");
                while (exerciseSet.next()) {
                    workout.add(exerciseSet.getString("exercise"));
                    workout.add(exerciseSet.getString("exercise_duration"));
                }
                userWorkouts.add(workout);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(userWorkouts);
        return userWorkouts;
    }


    public ArrayList<ArrayList<String>> getFriendWorkouts(String u,LeaderBoardGUI g){


        ArrayList<String> friends = getFriends(u);


        ArrayList<ArrayList<String>> userWorkouts = new ArrayList<>();
        ArrayList<String> workout = new ArrayList<>();
        try {
            Statement getWorkoutStatement = networkDriver.network.createStatement();
            for (int i=0;i<friends.size();i++){
                ResultSet workoutSet = getWorkoutStatement.executeQuery("select * from "+friends.get(i)+"workouts where exercise is null;");
                while (workoutSet.next()) {
                    workout.add(friends.get(i));
                    workout.add(workoutSet.getString("name"));
                    workout.add(workoutSet.getString("comment"));
                    workout.add(workoutSet.getString("total_duration"));
                    workout.add(workoutSet.getString("date"));
                    Statement getExerciseStatement = networkDriver.network.createStatement();
                    ResultSet exerciseSet = getExerciseStatement.executeQuery("select * from "+u+"workouts where exercise is not null and name='"+workout.get(0)+"';");
                    while (exerciseSet.next()) {
                        workout.add(exerciseSet.getString("exercise"));
                        workout.add(exerciseSet.getString("exercise_duration"));
                    }
                    userWorkouts.add(workout);

                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(userWorkouts);
        return userWorkouts;
    }
}
