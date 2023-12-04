import javax.swing.*;
import java.awt.event.ActionEvent;

public class Load_Profile {

    DisplayLogin f= new DisplayLogin();
    Home_GUI h = new Home_GUI();

    public void login(){

        f.init();


        f.btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                System.out.println("Button pressed");
                f.close();
                f.open = false;
                h.init();
            }
        });

    }


}
