import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Edit_Workout_GUI extends JFrame implements ActionListener {
    private JTextField  workoutName;
    private JTextField  exerciseEntry;
    private JTextField  durationEntry;
    private JButton completeWorkout;
    private JButton addNewExercise;
    private ArrayList<String> exerciseArr = new ArrayList<String>();
    private ArrayList<String> durationArr = new ArrayList<String>();;
    private String workName;
    private String username = "filler";
    private String comment;
    private JLabel exLabel;
    private String date;



    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui

    public Edit_Workout_GUI(String date) {

        this.date = date;//date to sort by

        //creating JFRAME
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when you press x
        f.setTitle("Edit Workout"); //Title of window
        f.setLayout(new GridBagLayout());

        gbc.insets =new Insets(5,5,5,5);

        //Instructions for name
        JLabel workLabel = new JLabel("Enter Name of Workout:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets =new Insets(5,5,0,5);
        f.add(workLabel,gbc);

        //Textfield for name
        workoutName = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(workoutName, gbc);


        //label for exercise input
        exLabel = new JLabel("Enter Exercise:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,0,5);
        f.add(exLabel,gbc);

        //exercise entry text field
        exerciseEntry = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(0,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(exerciseEntry, gbc);

        //label for duration textfield
        JLabel durLabel = new JLabel("Enter Duration of workout:");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,0,5);
        f.add(durLabel, gbc);

        //duration entry textfield
        durationEntry = new JTextField("");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(0,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(durationEntry, gbc);


        //button for adding another exercise to the workout
        addNewExercise = new JButton("Add another exercise");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addNewExercise.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==addNewExercise){
                            exerciseArr.add(exerciseEntry.getText());
                            durationArr.add(durationEntry.getText());
                            JOptionPane.showMessageDialog(null, "Exercise Added: \n"+ "You completed '"+exerciseEntry.getText()+ "' for "+durationEntry.getText()+" minutes.\n"+"Please add another exercise or complete workout.");
                            exerciseEntry.setText("");
                            durationEntry.setText("");
                        }
                    }
                }
        );
        f.add(addNewExercise,gbc);

        //Instructions for comment
        JLabel workComment = new JLabel("Enter Comment for Workout:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2 ;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,0,5);
        f.add(workComment,gbc);

        //Textfield for comment
        JTextField workoutCom = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(workoutCom, gbc);

        //button for completeing workout and sending it to Add_Workout.java
        completeWorkout = new JButton("Complete Workout");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(0,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        completeWorkout.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Add_Workout add = new Add_Workout();
                        if(e.getSource()==completeWorkout){
                            workName = workoutName.getText();
                            comment = workoutCom.getText();

                            add.editExercise(username,workName,comment, date, exerciseArr,durationArr);

                            JOptionPane.showMessageDialog(null, "Edits Saved");
                            f.dispose();
                            Workout_Viewer view = new Workout_Viewer();
                        }
                    }
                }
        );
        f.add(completeWorkout, gbc);

        JLabel display = new JLabel("Current Workout");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;

        f.add(display,gbc);



        //finish the JFrame
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        String date = "Thu Dec 07 13:57:02 MST 2023";
        Edit_Workout_GUI run = new Edit_Workout_GUI(date);
    }
}
