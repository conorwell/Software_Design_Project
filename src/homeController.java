

import javax.swing.*;
import java.awt.event.ActionEvent;

public class homeController {

    Home_GUI home = new Home_GUI();
    recController rc = new recController();
    Add_Workout aw = new Add_Workout();




    public static void main(String[] args){
        homeController hc = new homeController();
        //hc.homePage("");

    }
    public void homePage(User u){
        home.init(u.getUsername());
        home.recBtn.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Recommender")) {
                    System.out.println("rec screen requested");
                    rc.getRec(u.getUsername());
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
                    aw.guiController(u.getUsername());
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
                    w.addData(u.getUsername());
                }
            }
        });

        home.friendButton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if (s.equals("Friends")) {
                    System.out.println("friends screen requested");
                    Friends.FriendsGUI friendsGUI = new Friends.FriendsGUI(u.getUsername());
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
                    leader.init(u);
                }
            }
        });

        home.statsButton.addActionListener(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if (s.equals("Stats")) {
                    System.out.println("stats screen requested");
                    statsController statistics = new statsController();
                    statistics.viewStats(u.getUsername());
                }
            }
        });

        home.logout.addActionListener(new AbstractAction()  {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String s = actionEvent.getActionCommand();
                if (s.equals("Logout")) {
                    System.out.println("logout requested");
                    home.f.dispose();
                    Load_Profile load = new Load_Profile();
                    load.login();
                }
            }
        });


    }
}
