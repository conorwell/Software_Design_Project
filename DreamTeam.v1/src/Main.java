import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame start = new JFrame();
        JButton loginbtn = new JButton("Login Test!");
        JButton createbtn = new JButton("Create Profile Test!");

        loginbtn.setSize(50,40);
        createbtn.setSize(50,40);
        start.setSize(400,500);

        start.add(loginbtn);
        start.add(createbtn);


        start.setVisible(true);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLayout(new FlowLayout());

        loginbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                System.out.println("Login Button pressed");
                start.setVisible(false);

                Load_Profile load = new Load_Profile();
                load.login();
            }
        });

        createbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                System.out.println("Create Button pressed");
                start.setVisible(false);

                Create_Profile create = new Create_Profile();
                create.create();
            }
        });


    }
}
