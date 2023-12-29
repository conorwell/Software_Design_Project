import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderBoardGUITest {
    @Test
    void init(){
        LeaderBoardGUI leader = new LeaderBoardGUI();
        User user = new User("sebolson", "password");
        leader.init(user);
        assertTrue(leader.f.isVisible());


    }

}
