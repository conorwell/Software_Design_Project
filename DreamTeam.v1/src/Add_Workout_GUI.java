import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Add_Workout_GUI extends JFrame implements ActionListener {
     JTextField  workoutName;
     JComboBox<String>  exerciseEntry;
     JComboBox<Integer>  durationEntry;
     JButton completeWorkout;
     JButton addNewExercise;
     JTextArea dispTextDur;
     JTextArea dispTextExer;
    JTextField workoutCom;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;
    JFrame f = new JFrame();

    private String username;

    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui


    public void Add_Workout_GUI(String user) {
        //f.setVisible(false);
        this.username = user;
        f = new JFrame();

        //creating JFRAME

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when you press x
        f.setTitle("Add Workout"); //Title of window
        f.setLayout(new GridBagLayout());

        TitledBorder border = BorderFactory.createTitledBorder("Please add your exercises then click 'Complete Workout'");
        border.setTitleColor( Color.RED );

        f.getRootPane().setBorder(border);


        gbc.insets =new Insets(5,5,5,5);

        //Instructions for name
        JLabel workLabel = new JLabel("Enter Name of Workout:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,0,5);
        gbc.fill = GridBagConstraints.NONE;
        f.add(workLabel,gbc);

        //Textfield for name
        workoutName = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(workoutName, gbc);


        //Instructions for name
        JLabel dateLabel = new JLabel("Select Date of Workout:");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        gbc.insets =new Insets(5,5,0,5);
        f.add(dateLabel,gbc);


        //this comes from external code
        //this is a date picker
        //https://sourceforge.net/projects/jdatepicker/files/latest/download
        UtilDateModel model = new UtilDateModel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
         datePanel = new JDatePanelImpl(model,p);
         datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        f.add(datePicker, gbc);

        //label for exercise input
        JLabel exLabel = new JLabel("Select Exercise:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,5,5);
        f.add(exLabel,gbc);

        //exercise entry drop down
        String[] exerChoice = {"Run", "Hike", "Ski", "Climb", "Bike", "Weight Train", "Juggle", "Game"};
        exerciseEntry = new JComboBox<>(exerChoice);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(exerciseEntry, gbc);

        //label for duration textfield

        JLabel durLabel = new JLabel("Select Duration of workout:");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets =new Insets(5,5,5,5);
        f.add(durLabel, gbc);

        //duration entry dropdown
        Integer[] durChoice = {0, 15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 165, 180};
        durationEntry = new JComboBox<>(durChoice);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
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
        workoutCom = new JTextField("");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(workoutCom, gbc);


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


        //button for completeing workout and sending it to Add_Workout.java


        //button for adding another exercise to the workout
        addNewExercise = new JButton("Add exercise");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(addNewExercise,gbc);


        completeWorkout = new JButton("Complete Workout");
        completeWorkout.setEnabled(false);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets =new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(completeWorkout, gbc);


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
        Add_Workout_GUI run = new Add_Workout_GUI();

        run.Add_Workout_GUI("conor");

    }
}
