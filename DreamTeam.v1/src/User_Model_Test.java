import java.util.List;

public class User_Model_Test {
    public static void main(String[] args) {
        System.out.println(testAddGetUsers());
        System.out.println(testEditUsers());
    }

    private static boolean testAddGetUsers(){
        boolean pass = false;
        User_Model model = new User_Model();
        model.addUser("12345","conorwell","testUsers.csv");
        model.addUser("123","sebo","testUsers.csv");
        model.addUser("560","heny","testUsers.csv");
        List<List<String>> users = model.getUsers("testUsers.csv");
        System.out.println(users);
        if (users.get(1).get(1).equals("123") && users.get(0).get(0).equals("conorwell")){
            pass = true;
        }

        return pass;
    }

    private static boolean testEditUsers(){
        boolean pass = false;
        User_Model model = new User_Model();
        model.addUser("12345","conorwell","testUsers.csv");
        model.addUser("123","sebo","testUsers.csv");
        model.addUser("560","heny","testUsers.csv");
        List<List<String>> users = model.getUsers("testUsers.csv");

        model.editUser("560","heny","567","henry", "testUsers.csv");
        System.out.println(users);
        List<List<String>> newUsers = model.getUsers("testUsers.csv");
        if (newUsers.get(2).get(1).equals("567") && newUsers.get(2).get(0).equals("henry")){
            pass = true;
        }

        return pass;
    }
}
