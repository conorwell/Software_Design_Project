import java.util.List;

import static org.junit.Assert.*;

public class User_ModelTest {
    @org.junit.jupiter.api.Test
    void addUser_getUser() {
        User_Model model = new User_Model();
        model.addUser("12345","conorwell","testUsers.csv");
        model.addUser("123","sebo","testUsers.csv");
        model.addUser("560","heny","testUsers.csv");
        List<List<String>> users = model.getUsers("testUsers.csv");
        assertEquals(users.get(0).get(0), "conorwell");
        assertEquals(users.get(0).get(1), "12345");
        assertEquals(users.get(1).get(0), "sebo");
        assertEquals(users.get(1).get(1), "123");
        assertEquals(users.get(2).get(0), "heny");
        assertEquals(users.get(2).get(1), "560");
    }

    @org.junit.jupiter.api.Test
    void editUser() {
            User_Model model = new User_Model();
            model.addUser("12345","conorwell","testUsers.csv");
            model.addUser("123","sebo","testUsers.csv");
            model.addUser("560","heny","testUsers.csv");
            List<List<String>> users = model.getUsers("testUsers.csv");
            model.editUser("560","heny","567","henry", "testUsers.csv");
            List<List<String>> newUsers = model.getUsers("testUsers.csv");
            assertEquals(newUsers.get(0).get(0), "conorwell");
            assertEquals(newUsers.get(0).get(1), "12345");
            assertEquals(newUsers.get(1).get(0), "sebo");
            assertEquals(newUsers.get(1).get(1), "123");
            assertEquals(newUsers.get(2).get(0), "henry");
            assertEquals(newUsers.get(2).get(1), "567");

        }
    }
