import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DisplayLogin {
    JFrame f = new JFrame();
    JButton btn = new JButton("Enter");
    JTextField username = new JTextField(16);
    JTextField password = new JTextField(16);
    boolean open = false;

    public void init(){
        open = true;
        f.setSize(400,500);

        btn.setSize(50,40);
        username.setText("username");
        password.setText("password");
        f.add(btn);
        f.add(username);
        f.add(password);


        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
    }

    public void close(){

        f.setVisible(false);

    }


}
