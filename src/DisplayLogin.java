import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DisplayLogin extends Canvas{
    JFrame f = new JFrame();
    JButton btn = new JButton("Enter");
    JButton noUser = new JButton("Create Account");
    JTextField username = new JTextField(16);
    JPasswordField password = new JPasswordField(16);
    JTextArea title = new JTextArea("Login to DreamTeam Athletics");
    //ImageIcon logo = new ImageIcon("C:\\Users\\olson\\dreamteam\\DreamTeam.jpg");
    boolean open = false;


    public void init(){
        open = true;
        //f.setSize(400,500);
        title.setEditable(false);
        btn.setSize(50,40);
        username.setText("username");
        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                username.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });
        password.setText("password");
        password.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                password.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });


        f.add(title);
        f.add(username);
        f.add(password);
        f.add(btn);
        f.add(noUser);
        f.pack();
        f.setSize(400,500);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
    }

    public void close(){
        open = false;
        f.setVisible(false);

    }



}