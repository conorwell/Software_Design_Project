

import javax.swing.*;
import java.awt.event.ActionEvent;

public class homeController {

    Home_GUI home = new Home_GUI();
    recController rc = new recController();
    Add_Workout aw = new Add_Workout();




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
                    aw.guiController(username);
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
                    Workout_Viewer_Controller w = new Workout_Viewer_Controller();
                    w.addData(username);
                }
            }
        });

        home.friendButton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if (s.equals("Friends")) {
                    System.out.println("friends screen requested");
                    Friends.FriendsGUI friendsGUI = new Friends.FriendsGUI(username);
                }
            }
        });

        home.leaderButton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if (s.equals("Leaderboard")) {
                    System.out.println("leaderboard screen requested");
                    LeaderBoardController leader = new LeaderBoardController();
                    leader.leaderboard(username);
                }
            }
        });

    }
}
