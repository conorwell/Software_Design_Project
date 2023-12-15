import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class User_ModelTest {
    @org.junit.jupiter.api.Test
    void addUser_getUser() {
        User_Model model = User_Model.getInstance();
        model.addUser("12345","conorwell","DreamTeam.v1/tests/testUsers.csv");
        model.addUser("123","sebo","DreamTeam.v1/tests/testUsers.csv");
        model.addUser("560","heny","DreamTeam.v1/tests/testUsers.csv");
        List<List<String>> users = model.getUsers("DreamTeam.v1/tests/testUsers.csv");
        assertEquals(users.get(0).get(0), "conorwell");
        assertEquals(users.get(0).get(1), "12345");
        assertEquals(users.get(1).get(0), "sebo");
        assertEquals(users.get(1).get(1), "123");
        assertEquals(users.get(2).get(0), "heny");
        assertEquals(users.get(2).get(1), "560");
    }

    @org.junit.jupiter.api.Test
    void editUser() {
            User_Model model = User_Model.getInstance();
            model.addUser("12345","conorwell","DreamTeam.v1/tests/testUsers.csv");
            model.addUser("123","sebo","DreamTeam.v1/tests/testUsers.csv");
            model.addUser("560","heny","DreamTeam.v1/tests/testUsers.csv");
            List<List<String>> users = model.getUsers("DreamTeam.v1/tests/testUsers.csv");
            model.editUser("560","heny","567","henry", "DreamTeam.v1/tests/testUsers.csv");
            List<List<String>> newUsers = model.getUsers("testUsers.csv");
            assertEquals(newUsers.get(0).get(0), "conorwell");
            assertEquals(newUsers.get(0).get(1), "12345");
            assertEquals(newUsers.get(1).get(0), "sebo");
            assertEquals(newUsers.get(1).get(1), "123");
            assertEquals(newUsers.get(2).get(0), "henry");
            assertEquals(newUsers.get(2).get(1), "567");

        }

    @org.junit.jupiter.api.Test
    void getInstance(){
        User_Model um = User_Model.getInstance();
        assertEquals(um, User_Model.getInstance());
    }

    }
