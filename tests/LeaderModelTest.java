import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
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
        ArrayList<ArrayList<String>> userWorkouts;
        userWorkouts = l.getOwnWorkouts("sebolson",g);
        assertFalse(userWorkouts.isEmpty());

        ArrayList<ArrayList<String>> friendWorkouts;
        friendWorkouts = l.getFriendWorkouts("sebolson",g);
        assertFalse(friendWorkouts.isEmpty());

    }

}
