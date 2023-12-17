import java.util.ArrayList;

public class User implements UserInterface{

    private String username;

    private String password;

    ArrayList<User> Friends;
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.Friends = new ArrayList<User>();
    }

    public void addFriend(User friend){
        this.Friends.add(friend);
    }

    public ArrayList<User> getFriends(){
        return this.Friends;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }
}
