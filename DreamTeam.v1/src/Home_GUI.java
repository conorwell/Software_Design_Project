import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Home_GUI extends JFrame{
    JFrame f = new JFrame();
    public void init(){

        f.setSize(400,500);

        JButton btn = new JButton("Home Test!");
        btn.setSize(50,40);
        f.add(btn);


        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
    }


}
