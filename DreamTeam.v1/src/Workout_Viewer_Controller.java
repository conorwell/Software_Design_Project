import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

public class Workout_Viewer_Controller {
    Workout_Viewer wv = new Workout_Viewer();
    Workout_Model wm = Workout_Model.getInstance();

    public void addData(String username) {
        wv.Workout_Viewer_Run(username);
        //table and file

        try {
            ArrayList<ArrayList<String>> data = wm.getWorkouts(username); //need to get active username

            for (int i = 0; i < data.size(); i++) {
                Vector row = new Vector();
                for (int j = 0; j < data.get(i).size(); j++) {
                    if (i == 0) {
                        wv.defTab.addColumn(data.get(i).get(j));
                    } else {
                        row.add(data.get(i).get(j));
                    }
                }
                if(i!= 0){
                wv.defTab.addRow(row); //adding data to table
                }

            }

        } catch (Exception e) {
            System.out.println("It was this");
        }


        wv.edit.addActionListener( //action listner for button
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == wv.edit && wv.tab.getSelectedRow() != -1) {
                            int row = wv.tab.getSelectedRow();
                            String value = wv.tab.getModel().getValueAt(row, 3).toString();
                            String com = wv.tab.getModel().getValueAt(row, 1).toString();
                            String nam = wv.tab.getModel().getValueAt(row, 0).toString();
                            Edit_Workout_Controller ed = new Edit_Workout_Controller();
                            ed.editListen(value, com, nam, username);
                            wv.fe.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select the workout you wish to edit");
                        }
                    }
                }
        );
        wv.fe.pack();
    }

    public static void main(String[] args) {
        Workout_Viewer_Controller w = new Workout_Viewer_Controller();
        w.addData("thehankstah");
    }
}
