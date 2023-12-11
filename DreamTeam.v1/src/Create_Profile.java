

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Create_Profile {

    DisplayCreateProfile f= new DisplayCreateProfile();
    Load_Profile l = new Load_Profile();
    User_Model user = new User_Model();

    public void create(){

        f.init();


        f.btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Enter")) {
                    String username = f.username.getText();
                    if (!Objects.equals(f.username.getText(), "") && !Objects.equals(f.password.getText(), "")){
                        System.out.println(f.username.getText());
                        user.addUser(f.username.getText(),f.password.getText(),"users.csv");
                        Friends.FriendsMain.createFriendsList(username);
                        System.out.println("enter pressed");
                        f.close();
                        f.open = false;
                        l.login();
                    }
                    else{
                        System.out.println("please enter a valid password");
                    }


                }




            }
        });

        f.back.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Back to login")) {
                    f.close();
                    Load_Profile load = new Load_Profile();
                    load.login();
                }




            }
        });

    }

}