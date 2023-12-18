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
    private ArrayList<ArrayList<String>> data;
    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui
    Workout_Model workoutModel = new Workout_Model();
    public Workout_Viewer(String u){
        this.usernam = u;
        JFrame fe = new JFrame("Workout Viewer");
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


        Load_Profile lp = new Load_Profile();

        //table and file
        File workouts = new File("workouts.csv"); //creating file to read from
        DefaultTableModel defTab = new DefaultTableModel(){ //creating table model
            @Override
            public boolean isCellEditable(int row, int column) { //declaring table is not editable
                //all cells false
                return false;
            }
        };

        try{
            data = workoutModel.getWorkouts("username"); //need to get active username

            for(int i = 0; i<data.size(); i++){
                Vector row = new Vector();
                for(int j = 0; j<data.get(i).size(); j++){
                    if(i==0){
                        defTab.addColumn(data.get(i).get(j));
                    }else{
                            row.add(data.get(i).get(j));
                    }
                }
                //if(i!= 0){
                    defTab.addRow(row); //adding data to table
                //}

            }

        }catch(Exception e){
            System.out.println("It was this");
        }

        JTable tab = new JTable(); //adding table
        tab.setModel(defTab);
        fe.add(tab);

        JScrollPane scroll = new JScrollPane(); //scroll plane that displays table
        scroll.getViewport().add(tab);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        fe.add(scroll,gbc);


        JButton edit = new JButton("Edit Workout"); //edit workkout button
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        fe.add(edit, gbc);

        edit.addActionListener( //action listner for button
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()==edit && tab.getSelectedRow() != -1){
                            int row = tab.getSelectedRow();
                            String value = tab.getModel().getValueAt(row, 4).toString();
                            String com = tab.getModel().getValueAt(row, 2).toString();
                            String nam = tab.getModel().getValueAt(row, 1).toString();
                            Edit_Workout_Controller ed = new Edit_Workout_Controller();
                            ed.editListen(value, com, nam, usernam);
                            fe.dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "Please select the workout you wish to edit");
                        }
                    }
                }
        );
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

