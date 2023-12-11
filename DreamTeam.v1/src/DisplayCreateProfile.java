import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DisplayCreateProfile {

    JFrame f = new JFrame();
    JButton btn = new JButton("Enter");
    JButton back = new JButton("Back to login");
    JTextField username = new JTextField(16);
    JPasswordField password = new JPasswordField(16);
    JTextArea title = new JTextArea("Join DreamTeam Athletics");
    boolean open = false;

    public void init(){
        open = true;
        f.setSize(400,500);
        title.setEditable(false);
        username.setText("username");
        password.setText("password");
        btn.setSize(50,40);

        username.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                username.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {

            }
        });

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
        f.add(back);


        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
    }

    public void close(){
        open = false;
        f.setVisible(false);

    }

}