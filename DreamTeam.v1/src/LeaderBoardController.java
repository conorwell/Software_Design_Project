public class LeaderBoardController implements SubjectInterface{
    LeaderBoardGUI f = new LeaderBoardGUI();

    public void leaderboard(User u){
        f.init(u);
    }
}
