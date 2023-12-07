import javax.swing.*;
import java.awt.event.ActionEvent;

public class recController {
    recommenderGUI r = new recommenderGUI();
    workoutReccomender wr = new workoutReccomender();

    public static void main(String[] args) {
        recController rc = new recController();
        rc.getRec("conorwell");
    }

    public void getRec(String username) {
        r.init();
        r.btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("Get Recommendation!")) {
                    System.out.println("recommendation requested");
                    r.resp.setText(wr.reccomend(username));
                }
            }
        });
    }
}
