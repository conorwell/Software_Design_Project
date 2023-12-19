import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Vector;

public class Workout_Viewer extends JFrame implements ActionListener {

    private String usernam;
    JFrame fe;
    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui
    Workout_Model workoutModel = new Workout_Model();
    DefaultTableModel defTab = new DefaultTableModel(); //creating table model
    JButton edit = new JButton();
    JTable tab = new JTable();
    //Workout_Viewer_Controller wc = new Workout_Viewer_Controller();
    public void Workout_Viewer_Run(String u){
        this.usernam = u;

        fe = new JFrame("Workout Viewer");
        fe.setDefaultCloseOperation(2); //closes when you press x
        fe.setTitle("Workout Viewer"); //Title of window
        fe.setLayout(new GridBagLayout());
        gbc.insets =new Insets(5,5,5,5);

        JLabel title = new JLabel("Workout History"); //title for page
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        fe.add(title, gbc);


        defTab = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) { //declaring table is not editable
                //all cells false
                return false;
            }
        };


        //wc.addData(usernam);

        tab = new JTable(); //adding table
        tab.setModel(defTab);
        fe.add(tab);

        JScrollPane scroll = new JScrollPane(); //scroll plane that displays table
        scroll.getViewport().add(tab);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        fe.add(scroll,gbc);


        edit = new JButton("Edit Workout"); //edit workkout button
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        fe.add(edit, gbc);


        fe.pack();
        fe.setLocationRelativeTo(null);
        fe.setVisible(true);

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

