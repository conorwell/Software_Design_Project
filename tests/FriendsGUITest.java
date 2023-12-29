import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FriendsGUITest{

    @Test
    void initGUI() {
        try {
            FriendsMain friendsMain = new FriendsMain;
            friendsMain.createFriendsList("test");
            FriendsGUI f = new FriendsGUI("test");
            assertTrue(f.isVisible());
            friendsMain.deleteFriendsList("test");
            assertTrue(f.friendsTableVisible);
            return;
        }catch(Exception e){
            fail("Window couldnt be created");
        }

    }
}