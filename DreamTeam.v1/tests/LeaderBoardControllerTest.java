import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LeaderBoardControllerTest {
    @Test
    void leaderboard(){
        LeaderBoardController leader = new LeaderBoardController();
        User user = new User("sebolson", "password");
        leader.f.init(user);
        assertTrue(leader.f.f.isVisible());
    }
}
