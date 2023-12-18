import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LeaderBoardControllerTest {
    @Test
    void leaderboard(){
        LeaderBoardController leader = new LeaderBoardController();
        leader.f.init("sebolson");
        assertTrue(leader.f.f.isVisible());
    }
}
