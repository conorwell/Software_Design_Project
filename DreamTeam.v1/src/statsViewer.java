import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class statsViewer {
    JFrame f = new JFrame();

    JTextPane desc = new JTextPane();

    JButton exit = new JButton();
    JTable tab = new JTable();
    DefaultTableModel defTab = new DefaultTableModel();
    public void init(){

            f.setSize(400,500);

            desc.setText("Workout Statistics:");
            desc.setEditable(false);
            f.add(desc);

            tab = new JTable(); //adding table
            tab.setModel(defTab);
            f.add(tab);

            exit.setText("EXIT");
            exit.setSize(50,40);
            f.add(exit);

            f.setVisible(true);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(new FlowLayout());

        }

        public void close(){
            f.setVisible(false);
        }
}


