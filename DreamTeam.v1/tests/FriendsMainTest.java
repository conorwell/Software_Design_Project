import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class FriendsMainTest{

    @Test
    void createFriendsList(){
        try {
            FriendsMain friendsMain = new FriendsMain;
            friendsMain.createFriendsList("test");
            friendsMain.deleteFriendsList("test");
            return;
        }
        catch{
            fail("Friends list couldn't be created");
        }
    }

    @Test
    void sendAcceptRequest(){
        try {
            FriendsMain friendsMain = new FriendsMain;
            friendsMain.createFriendsList("test");
            friendsMain.createFriendsList("test2");
            friendsMain.sendRequest("test,test2");
            friendsMain.acceptRequest("test2,test");
            ArrayList<String> friendsList = friendsMain.getFriendsList("test");
            assertEquals(friendsList.get(0),"test2")
            ArrayList<String> friendsList2 = friendsMain.getFriendsList("test2");
            assertEquals(friendsList.get(0),"test")
            return;
        }
        catch{
            fail("Couldn't write to friendslists");
        }
    }

    @Test
    void sendDenyRequest(){
        try {
            FriendsMain friendsMain = new FriendsMain;
            friendsMain.createFriendsList("test");
            friendsMain.createFriendsList("test2");
            friendsMain.sendRequest("test,test2");
            friendsMain.denyRequest("test2,test");
            ArrayList<String> friendsList = friendsMain.getFriendsList("test");
            assertTrue(friendsList.isEmpty())
            ArrayList<String> friendsList2 = friendsMain.getFriendsList("test2");
            assertTrue(friendsList.isEmpty())
            return;
        }
        catch{
            fail("Couldn't write to friendslists");
        }
    }

}