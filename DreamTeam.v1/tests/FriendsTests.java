/*
package DreamTeam.v1.tests;

import DreamTeam.v1.src.Friends.FriendsGUI;
import DreamTeam.v1.src.Friends.FriendsMain;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class FriendsTests {

    @Test
    @DisplayName("Create friends list")
    void createTest() {
        try{
            FriendsMain.createFriendsList("test");
            File testFile = new File("./FriendsLists/test_Friends.csv");
            testFile.delete();
            return;
        }catch(Exception e){
            fail("DreamTeam.v1.src.Friends list file couldn't be created");
        }
    }

    @Test
    @DisplayName("Send/accept friend request")
    void requestTest() {
        try{
            FriendsMain.createFriendsList("test");
            File testFile = new File("./FriendsLists/test_Friends.csv");
            FriendsMain.createFriendsList("test2");
            File test2File = new File("./FriendsLists/test2_Friends.csv");
            FriendsMain.sendRequest("Test","Test2");
            FriendsMain.acceptRequest("Test2","Test");
            testFile.delete();test2File.delete();
            return;
        }catch(Exception e){
            fail("Friend request couldn't be sent/accepted");
        }
    }
    @Test
    @DisplayName("Load GUI")
    void guiTest() {
        try{
            System.out.println("Error message below ok, caused by JUnit closing window once test is complete:");
            FriendsGUI friendsGUI = new FriendsGUI("Test");
            return;
        }catch(Exception e){
            fail("GUI couldn't be loaded");
        }
    }
}

 */
