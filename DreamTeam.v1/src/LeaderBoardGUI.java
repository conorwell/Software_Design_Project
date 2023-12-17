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

        LeaderModel m = new LeaderModel();
        DefaultTableModel defTab = m.getWorkouts(u,this);

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
