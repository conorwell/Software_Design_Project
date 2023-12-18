import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LeaderModelTest {
    @Test
    void testFriends(){
        LeaderModel l = new LeaderModel();
        ArrayList<String> friends = l.getFriends("sebolson");
        assertTrue(friends.contains("henry"));
        assertTrue(friends.contains("another1"));

    }

    @Test
    void testWorkouts(){
        LeaderModel l = new LeaderModel();
        LeaderBoardGUI g = new LeaderBoardGUI();
        DefaultTableModel workouts = l.getWorkouts("sebolson",g);
        assertEquals(workouts.getRowCount(),2);

    }

}
