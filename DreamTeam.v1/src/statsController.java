import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class statsController {
    statsViewer sv = new statsViewer();
    Workout_Model wm = Workout_Model.getInstance();

    public void viewStats(String username){
        sv.init();
        ArrayList<ArrayList<String>> data = getData(wm.getWorkouts(username));


        for (int i = 0; i < data.size(); i++) {
            Vector row = new Vector();
            for (int j = 0; j < data.get(i).size(); j++) {
                if (i == 0) {
                    sv.defTab.addColumn(data.get(i).get(j));
                } else {
                    row.add(data.get(i).get(j));
                }
            }
            if(i!= 0){
                sv.defTab.addRow(row); //adding data to table
            }
        }

        sv.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("EXIT")) {
                    System.out.println("exit rec screen");
                    sv.close();
                }
            }
        });
    }

    public ArrayList<ArrayList<String>> getData(ArrayList<ArrayList<String>> workouts){
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        ArrayList<String> exercises = new ArrayList<>();
        ArrayList<Integer> durations = new ArrayList<>();
        ArrayList<String> headers = new ArrayList(Arrays.asList("Exercise:","Sessions:","Total Time:"));
        ArrayList<String> buffer = new ArrayList(Arrays.asList("","",""));
        data.add(buffer);
        data.add(headers);

        for(ArrayList<String> workout:workouts) {
            for (int i = 4; i < workout.size(); i += 2) {
                exercises.add(workout.get(i));
            }
            for (int i =5; i < workout.size(); i+= 2){
                durations.add(Integer.valueOf(workout.get(i)));
            }
        }
        ArrayList<String> types = new ArrayList<>(Arrays.asList("Run", "Hike", "Ski", "Climb", "Bike", "Weight Train", "Juggle", "Game"));
        ArrayList<Integer> sessions = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));
        ArrayList<Integer> time = new ArrayList<>(Arrays.asList(0,0,0,0,0,0,0,0));


        for(int i = 0; i< exercises.size();i++){
            if (exercises.get(i).equals("Run")){
                sessions.set(0, sessions.get(0)+1);
                time.set(0,time.get(0)+durations.get(i));
            }else if(exercises.get(i).equals("Hike")){
                sessions.set(1, sessions.get(1)+1);
                time.set(1,time.get(1)+durations.get(i));
            }else if(exercises.get(i).equals("Ski")){
                sessions.set(2, sessions.get(2)+1);
                time.set(2,time.get(2)+durations.get(i));
            }else if(exercises.get(i).equals("Climb")){
                sessions.set(3, sessions.get(3)+1);
                time.set(3,time.get(3)+durations.get(i));
            }else if(exercises.get(i).equals("Bike")){
                sessions.set(4, sessions.get(4)+1);
                time.set(4,time.get(4)+durations.get(i));
            }else if(exercises.get(i).equals("Weight Train")){
                sessions.set(5, sessions.get(5)+1);
                time.set(5,time.get(5)+durations.get(i));
            }else if(exercises.get(i).equals("Juggle")){
                sessions.set(6, sessions.get(6)+1);
                time.set(6,time.get(6)+durations.get(i));
            }else if(exercises.get(i).equals("Game")){
                sessions.set(7, sessions.get(7)+1);
                time.set(7,time.get(7)+durations.get(i));
            }
        }

        for(int i = 0; i<types.size();i++){
            ArrayList<String> current = new ArrayList<>();
            current.add(types.get(i));
            current.add(String.valueOf(sessions.get(i)));
            current.add(String.valueOf(time.get(i)));
            data.add(current);
        }

        return data;
    }
}
