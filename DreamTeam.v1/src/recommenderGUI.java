import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class recommenderGUI extends JFrame{

    JFrame f = new JFrame();
    JButton btn = new JButton();

    JTextPane desc = new JTextPane();

    JTextPane resp = new JTextPane();

    JButton exit = new JButton();
    public void init(){

        f.setSize(400,500);

        desc.setText("Ask ChatGPT for a recommendation for your next workout \n" +
                        "based on your most recent workout!");
        desc.setEditable(false);
        f.add(desc);


        btn.setSize(50,40);
        btn.setText("Get Recommendation!");
        f.add(btn);


        resp.setEditable(false);
        resp.setText("(response here)");
        resp.setPreferredSize(new Dimension(350,350));
        f.add(resp);

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
