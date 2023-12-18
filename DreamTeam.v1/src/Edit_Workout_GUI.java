import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Edit_Workout_GUI extends JFrame implements ActionListener {
    JTextField  workoutName;
     JComboBox<String>  exerciseEntry;
     JComboBox<Integer>  durationEntry;
     JButton completeWorkout;
     JButton addNewExercise;
    JTextArea dispTextDur;
    JTextArea dispTextExer;
    JLabel exLabel;
    JTextField workoutCom;

    JFrame fred = new JFrame();

    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui


    public void Edit_Workout_GUI_Run(String value, String com, String nam, String usernam) {


        //creating JFRAME
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(2); //closes when you press x
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
        workoutName = new JTextField(nam);
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

        //exercise entry drop down
        String[] exerChoice = {"Run", "Hike", "Ski", "Climb", "Bike", "Weight Train", "Juggle", "Game"};
        exerciseEntry = new JComboBox<>(exerChoice);
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

        //duration entry dropdown
        Integer[] durChoice = {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180};
        durationEntry = new JComboBox<>(durChoice);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(0,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(durationEntry, gbc);




        //Instructions for comment
        JLabel workComment = new JLabel("Enter Comment for Workout:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2 ;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,0,5);
        f.add(workComment,gbc);

        //Textfield for comment
         workoutCom = new JTextField(com);
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
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        completeWorkout.setEnabled(false);
        f.add(completeWorkout, gbc);

        //Current workout GUI stuff
        JLabel display = new JLabel("Current Workout");
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        f.add(display,gbc);

        //Current workout exercises
        JLabel displayExer = new JLabel("Exercises:");
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        f.add(displayExer,gbc);

        //current workout displaydur
        JLabel displayDur = new JLabel("Durations:");
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        f.add(displayDur,gbc);

        Color color = f.getBackground ();

        //current workout exercises display
        dispTextExer = new JTextArea("");
        dispTextExer.setBackground(color);
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,20,5);
        gbc.fill = GridBagConstraints.NONE;
        dispTextExer.setEditable(false);
        f.add(dispTextExer,gbc);

        //dispaly textDuration
        dispTextDur = new JTextArea("");
        dispTextDur.setBackground(color);
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,20,5);
        gbc.fill = GridBagConstraints.NONE;
        dispTextDur.setEditable(false);
        f.add(dispTextDur,gbc);

        //button for adding another exercise to the workout
        addNewExercise = new JButton("Add exercise");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(addNewExercise,gbc);



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

}
