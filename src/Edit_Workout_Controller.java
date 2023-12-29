import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Edit_Workout_Controller {

    private ArrayList<String> exerciseArr = new ArrayList<String>();
    private ArrayList<String> durationArr = new ArrayList<String>();
    private String workName;
    private String username;


    Edit_Workout_GUI edit = new Edit_Workout_GUI();

    public void editListen(String date, String comment, String name, String user){
        this.username=user;

        edit.Edit_Workout_GUI_Run(date, comment, name, user);

        edit.addNewExercise.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==edit.addNewExercise){
                            exerciseArr.add(edit.exerciseEntry.getSelectedItem().toString());
                            durationArr.add(edit.durationEntry.getSelectedItem().toString());

                            String one = "";
                            String two = "";
                            for(int i =0; i<exerciseArr.size();i++) { //logic for current workout feature
                                one = one+exerciseArr.get(i)+"\n";
                                two = two+durationArr.get(i)+"\n";
                            }
                            edit.dispTextExer.setText(one);
                            edit.dispTextDur.setText(two);
                            edit.fred.pack();

                            JOptionPane.showMessageDialog(null, "Exercise Added: \n"+ "You completed '"+edit.exerciseEntry.getSelectedItem()+ "' for "+edit.durationEntry.getSelectedItem()+" minutes.\n"+"Please add another exercise or complete workout.");
                            edit.completeWorkout.setEnabled(true);
                        }
                    }
                }
        );

        edit.completeWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Add_Workout add = new Add_Workout();
                        if(e.getSource()==edit.completeWorkout){
                            workName = edit.workoutName.getText();
                            String comment = edit.workoutCom.getText();

                            add.editExercise(username, workName, comment, date, exerciseArr,durationArr);
                            edit.fred.dispose();
                            JOptionPane.showMessageDialog(null, "Edits Saved");

                            //
                        }
                    }
                }
        );
    }

}
