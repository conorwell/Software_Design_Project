

import java.io.*;
import java.text.ParseException;
import java.util.*;


public final class Workout_Model {
    public static final Workout_Model wm = new Workout_Model();

    public static Workout_Model getInstance(){
        return wm;
    }


    public static List<List<String>> getWorkouts() {
        //create ArrayList of workouts
        List<List<String>> workouts = new ArrayList<>();


        //Read each line of csv file
        try (BufferedReader woBr = new BufferedReader(new FileReader("workouts.csv"))) {
            String line;
            //split lines by commas to separate user+password
            while ((line = woBr.readLine()) != null) {
                String[] values = line.split(",");
                workouts.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    public static List<List<String>> getWorkouts(String filePath, boolean test) {
        //create ArrayList of workouts
        List<List<String>> workouts = new ArrayList<>();
        System.out.println(test);
        //Read each line of csv file
        try (BufferedReader woBr = new BufferedReader(new FileReader(filePath))) {
            String line;
            //split lines by commas to separate user+password
            while ((line = woBr.readLine()) != null) {
                String[] values = line.split(",");
                workouts.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workouts;
    }

    public static List<List<String>> getWorkouts(String username) {
        //create ArrayList of workouts
        List<List<String>> workouts = new ArrayList<>();
        List<List<String>> userWorkouts = new ArrayList<>();

        //Read each line of csv file
        try (BufferedReader woBr = new BufferedReader(new FileReader("workouts.csv"))) {
            String line;
            //split lines by commas to separate user+password
            while ((line = woBr.readLine()) != null) {
                String[] values = line.split(",");
                workouts.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).get(0).equals(username)) {
                userWorkouts.add(workouts.get(i));
            }

        }
        return userWorkouts;
    }

    public static List<List<String>> getWorkouts(String username, String filePath) {
        //create ArrayList of workouts
        List<List<String>> workouts = new ArrayList<>();
        List<List<String>> userWorkouts = new ArrayList<>();

        //Read each line of csv file
        try (BufferedReader woBr = new BufferedReader(new FileReader(filePath))) {
            String line;
            //split lines by commas to separate user+password
            while ((line = woBr.readLine()) != null) {
                String[] values = line.split(",");
                workouts.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < workouts.size(); i++) {
            if (workouts.get(i).get(0).equals(username)) {
                userWorkouts.add(workouts.get(i));
            }

        }
        return userWorkouts;
    }

    public static void addWorkouts(String username, String workoutName, String comment, String totalDuration, String date, ArrayList<String> exercises, ArrayList<String> durations) {
        List<List<String>> workouts = getWorkouts();
        File workoutFile = new File("workouts.csv");
        try {
            // create FileWriter object with file as parameter
            FileWriter workoutWriter = new FileWriter(workoutFile);

            // add data to csv
            if (workouts.size() > 0) {
                for (int i = 0; i < workouts.size(); i++) {
                    for (int j = 0; j < workouts.get(i).size(); j++) {
                        //write existing workouts to csv file
                        workoutWriter.write(workouts.get(i).get(j) + ",");
                    }
                    workoutWriter.write("\n");
                }
            }
            // write workout into file:
            workoutWriter.write(username + "," + workoutName + "," + comment + "," + totalDuration + ",");
            workoutWriter.write(String.valueOf(date));
            for (int i = 0; i < exercises.size(); i++) {
                workoutWriter.write("," + exercises.get(i) + "," + durations.get(i));
            }
            // closing writer connection
            workoutWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void addWorkouts(String username, String workoutName, String comment, String totalDuration, String date, ArrayList<String> exercises, ArrayList<String> durations, String filePath) {
        List<List<String>> workouts = getWorkouts(filePath);
        File workoutFile = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter workoutWriter = new FileWriter(workoutFile);

            // add data to csv
            if (workouts.size() > 0) {
                for (int i = 0; i < workouts.size(); i++) {
                    for (int j = 0; j < workouts.get(i).size(); j++) {
                        //write existing workouts to csv file
                        workoutWriter.write(workouts.get(i).get(j) + ",");
                    }
                    workoutWriter.write("\n");
                }
            }
            // write workout into file:
            workoutWriter.write(username + "," + workoutName + "," + comment + "," + totalDuration + ",");
            workoutWriter.write(String.valueOf(date));
            for (int i = 0; i < exercises.size(); i++) {
                workoutWriter.write("," + exercises.get(i) + "," + durations.get(i));
            }
            // closing writer connection
            workoutWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editWorkout(String newUsername, String newWOName, String newComment, String newTotal, String date, String[] newExercises, String[] newDurations) throws ParseException {
        List<List<String>> workouts = getWorkouts();
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
