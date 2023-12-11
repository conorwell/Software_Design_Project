import javax.swing.*;
import java.awt.event.ActionEvent;

public class homeController {

   Home_GUI home = new Home_GUI();
    recController rc = new recController();

    Add_Workout_GUI aw = new Add_Workout_GUI();


    public static void main(String[] args){
        homeController hc = new homeController();
        hc.homePage("");
    }
    public void homePage(String username){
        home.init(username);
        home.recBtn.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Recommender")) {
                    System.out.println("rec screen requested");
                    rc.getRec(username);
                }
            }
        });

        home.addW.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Add Workout")) {
                    System.out.println("add workout screen requested");
                    aw.Add_Workout_GUI(username);
                }
            }
        });

        home.vw.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("View Workouts")) {
                    System.out.println("add workout screen requested");
                    Workout_Viewer wv = new Workout_Viewer(username);
                }
            }
        });
    }
}
