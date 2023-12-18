import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Load_Profile {

    DisplayLogin f= new DisplayLogin();
    homeController h = new homeController();
    User_Model user = new User_Model();
    private String globUser;

    public void login(){

        f.init();
        f.btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Enter")) {
                    boolean approver = user.approveUser(f.username.getText(), f.password.getText());
                    if (approver){
                        String user = f.username.getText();
                        globUser = user;
                        System.out.println("welcome " + f.username.getText());


                        System.out.println("enter pressed");
                        f.close();
                        f.open = false;
                        h.homePage(user);
                    }
                    else{
                        System.out.println("please enter a valid password");
                    }


                }

            }
        });

        f.noUser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Create Account")) {
                    f.close();
                    Create_Profile c = new Create_Profile();
                    c.create();


                }

            }
        });

    }
    public String getGlobUser(){
        return globUser;
    }


}