import java.util.ArrayList;

public interface UserInterface {
    void addFriend(User friend);
    ArrayList<User> getFriends();
    String getUsername();
    String getPassword();

}
