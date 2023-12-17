import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

public class LeaderBoardGUI {
    JFrame f = new JFrame();
    GridBagConstraints gbc = new GridBagConstraints(); //Layout for gui
    public ArrayList<ArrayList<String>> data;

    public void init(String u){
        //f.setSize(400,500);
        f.setLayout(new GridBagLayout());
        gbc.insets =new Insets(5,5,5,5);

        JLabel title = new JLabel("Leaderboard"); //title for page
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add(title, gbc);

        File workouts = new File("workouts.csv"); //creating file to read from
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
                Vector row = new Vector();
                for(int j = 0; j<data.get(i).size(); j++){
                    if(i==0){
                        defTab.addColumn(data.get(i).get(j));
                    }else{
                        if(!data.get(i).get(0).equals(u))
                            row.add(data.get(i).get(j));
                    }
                }
                if(i!= 0){
                    defTab.addRow(row); //adding data to table
                }

            }

        }catch(Exception e){
            System.out.println("It was this");
        }

        JTable tab = new JTable(); //adding table
        tab.setModel(defTab);
        f.add(tab);

        JScrollPane scroll = new JScrollPane(); //scroll plane that displays table
        scroll.getViewport().add(tab);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        f.add(scroll,gbc);

        f.setVisible(true);
        f.setTitle("Leaderboard");
        f.setDefaultCloseOperation(2);
        f.pack();
        f.setLocationRelativeTo(null);

    }
}
