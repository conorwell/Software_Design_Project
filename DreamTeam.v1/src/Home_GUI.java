import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Home_GUI extends JFrame{
    JFrame f = new JFrame();

    JButton recBtn = new JButton();

    JTextPane welcome = new JTextPane();

    JButton addW = new JButton();

    JButton vw = new JButton();
    public void init(String username){

        f.setSize(400,500);

        JButton btn = new JButton("Home Test!");
        btn.setSize(50,40);
        f.add(btn);

        welcome.setSize(new Dimension(300,40));
        welcome.setText("Hello " + username + "!");
        f.add(welcome);

        recBtn.setSize(50,40);
        recBtn.setText("Recommender");
        f.add(recBtn);

        addW.setText("Add Workout");
        addW.setSize(50,40);
        f.add(addW);

        vw.setText("View Workouts");
        vw.setSize(50,40);
        f.add(vw);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());


    }


}
