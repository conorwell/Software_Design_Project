import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_ModelTest {
    @org.junit.jupiter.api.Test
    void addUser_getUser() {
        User_Model model = User_Model.getInstance();
        User user1= new User("testuser1","12345");
        User user2= new User("testuser2","123");
        model.addUser(user1);
        model.addUser(user2);
        List<List<String>> users = model.getUsers();
        assertEquals(users.get(0).get(0), "testuser1");
        assertEquals(users.get(0).get(1), "12345");
        assertEquals(users.get(1).get(0), "testuser2");
        assertEquals(users.get(1).get(1), "123");
    }

    @org.junit.jupiter.api.Test
    void editUser() {
            User_Model model = User_Model.getInstance();
            User user3= new User("testuser3","560");
            model.addUser(user3);
            List<List<String>> users = model.getUsers();
            model.editUser("testuser3","567","testUser3");
            List<List<String>> newUsers = model.getUsers();
            assertEquals(newUsers.get(2).get(0), "testUser3");
            assertEquals(newUsers.get(2).get(1), "567");

        }

    @org.junit.jupiter.api.Test
    void getInstance(){
        User_Model um = User_Model.getInstance();
        assertEquals(um, User_Model.getInstance());
    }

    }
