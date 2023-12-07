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
        private ArrayList<ArrayList<String>> data;
        GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui
        public Workout_Viewer(){
            JFrame fe = new JFrame("Workout Viewer");
            fe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes when you press x
            fe.setTitle("Workout Viewer"); //Title of window
            fe.setLayout(new GridBagLayout());

            JLabel title = new JLabel("Workout History"); //title for page
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            fe.add(title, gbc);

            JButton edit = new JButton("Edit Workout"); //edit workkout button
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            fe.add(edit, gbc);
/*
            edit.addActionListener( //action listner for button
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource()==edit){
                                @Override
                                public boolean isCellEditable(int row, int column) { //declaring table is not editable
                                    //all cells false
                                    return true;
                                }
                            }
                        }
                    }
            );
            
 */




            //table and file
            File workouts = new File("users.csv"); //creating file to read from
            DefaultTableModel defTab = new DefaultTableModel(){ //creating table model
                @Override
                public boolean isCellEditable(int row, int column) { //declaring table is not editable
                    //all cells false
                    return false;
                }
            };

            try{ //reading csv file
                CSV_Parser read = new CSV_Parser();
                data = read.readCSV(workouts);

                for(int i = 0; i<data.size(); i++){
                    for(int j = 0; j<data.get(i).size(); j++){
                        if(i==0){
                            defTab.addColumn(data.get(i).get(j));
                        }else{
                            Vector row = new Vector();

                            for(int k = 0; k<data.get(i).size(); k++){
                                row.add(data.get(i).get(k));
                            }
                            defTab.addRow(row); //adding data to table
                        }
                    }
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

            fe.pack();
            fe.setLocationRelativeTo(null);
            fe.setVisible(true);

        }


        public static void main(String[] args) {
            Workout_Viewer w = new Workout_Viewer();

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
