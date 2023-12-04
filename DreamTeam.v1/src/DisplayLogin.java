import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DisplayLogin {
    JFrame f = new JFrame();
    JButton btn = new JButton("Login Test!");
    boolean open = false;

    public void init(){
        open = true;
        f.setSize(400,500);

        btn.setSize(50,40);
        f.add(btn);



        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
    }

    public void close(){

        f.setVisible(false);

    }


}
