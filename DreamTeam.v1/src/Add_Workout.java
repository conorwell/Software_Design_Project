import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Add_Workout {
    Add_Workout_GUI addGUI = new Add_Workout_GUI();

    private ArrayList<String> exerciseArr = new ArrayList<String>();
    private ArrayList<String> durationArr = new ArrayList<String>();;
    private String date;
    private Date datedate;

    //method that constructs an array list and returns it from the data from the gui
    public Workout addExercise(String user, String wrkName, String comment, String date, ArrayList<String> exerc, ArrayList<String> exerDur) {
        WorkoutBuilder_Concrete newWork = new WorkoutBuilder_Concrete();
        return newWork.workoutBuilder(user,wrkName,exerc,exerDur,comment,date);
    }
    public Workout editExercise(String user, String wrkName, String comment, String date, ArrayList<String> exerc, ArrayList<String> exerDur) {

        WorkoutBuilder_Concrete newWork = new WorkoutBuilder_Concrete();
        return newWork.workoutBuilder(user,wrkName,exerc,exerDur,comment,date);
    }

    public void guiController(String username){
        addGUI.Add_Workout_GUI("");
        //add workout controller
        addGUI.addNewExercise.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==addGUI.addNewExercise){
                            exerciseArr.add(addGUI.exerciseEntry.getSelectedItem().toString());
                            durationArr.add(addGUI.durationEntry.getSelectedItem().toString());

                            String one = "";
                            String two = "";
                            for(int i =0; i<exerciseArr.size();i++) { //logic for current workout feature
                                one = one+exerciseArr.get(i)+"\n";
                                two = two+durationArr.get(i)+"\n";
                            }
                            addGUI.dispTextExer.setText(one);
                            addGUI.dispTextDur.setText(two);
                            addGUI.f.pack();

                            JOptionPane.showMessageDialog(null, "Exercise Added: \n"+ "You completed '"+addGUI.exerciseEntry.getSelectedItem()+ "' for "+addGUI.durationEntry.getSelectedItem()+" minutes.\n"+"Please add another exercise or complete workout.");
                            addGUI.completeWorkout.setEnabled(true);
                        }
                    }
                }
        );
        //complete workout controller
        addGUI.completeWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Add_Workout add = new Add_Workout();
                        if(e.getSource()==addGUI.completeWorkout && addGUI.workoutName.getText() != null && addGUI.workoutCom.getText() != null && addGUI.datePicker.getModel().getValue() != null){
                            String workName = addGUI.workoutName.getText();
                            String comment = addGUI.workoutCom.getText();
                            datedate = (Date) addGUI.datePicker.getModel().getValue();
                            String dateString = datedate.toString();
                            add.addExercise(username,workName,comment, dateString,exerciseArr,durationArr);//logic for
                            addGUI.f.dispose();
                            JOptionPane.showMessageDialog(null, "Workout Completed :)");
                        } else{
                            JOptionPane.showMessageDialog(null, "Please complete all fields and try again");
                        }
                    }
                }
        );
    }

    public static void main(String[] args) {
        Add_Workout a = new Add_Workout();
        a.guiController("");
    }


}