import javax.swing.*;
import java.awt.event.ActionEvent;

public class recController {
    recommenderGUI r = new recommenderGUI();
    workoutReccomender wr = new workoutReccomender();




    public void getRec(String username) {
        r.init();
        r.btn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();
                try {
                    if (s.equals("Get Recommendation!")) {
                        System.out.println("recommendation requested");
                        r.resp.setText(wr.reccomend(username));
                        r.btn.setEnabled(false);
                    }
                }
                catch(Exception e){
                    r.resp.setText("Looks like you haven't completed a workout yet, come back once you have!");
                }
            }
        });

        r.exit.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //what happens when action
                String s = actionEvent.getActionCommand();

                if (s.equals("EXIT")) {
                    System.out.println("exit rec screen");
                    r.close();
                }
            }
        });
    }
}
