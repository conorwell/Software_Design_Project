import Network.NetworkDriver;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public final class User_Model {
    public static final User_Model um = new User_Model();
    public static User_Model getInstance(){
        return um;
    }
    NetworkDriver networkDriver = new NetworkDriver();

    public void addUser(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        try {
            Statement createStatement = networkDriver.network.createStatement();
            createStatement.executeUpdate("insert into UserTable values ('" + username + "','" + password + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public List<List<String>> getUsers() {
        List<List<String>> users_array = new ArrayList<>();
        try {
            Statement searchStatement = networkDriver.network.createStatement();
            ResultSet searchSet = searchStatement.executeQuery("select * from UserTable");
            System.out.println("Current userbase:");
            while (searchSet.next()) {
                System.out.println(searchSet.getString("username") + ", " + searchSet.getString("password"));
                ArrayList<String> user = new ArrayList<>();
                user.add(0,searchSet.getString("username"));
                user.add(1,searchSet.getString("password"));
                users_array.add(user);
            }
        } catch (Exception e) {
            System.out.println(e);
            }
            return users_array;
        }

    public boolean approveUser(String username, String password){
        try {
            Statement loginStatement = networkDriver.network.createStatement();
            ResultSet userSet = loginStatement.executeQuery("select * from UserTable");
            while (userSet.next()) {
                if (username.equals(userSet.getString("username")) && password.equals(userSet.getString("password"))) {
                    System.out.println("Login successful");
                    return true;
                } else if (username.equals(userSet.getString("username"))) {
                    System.out.println("Incorrect password");
                    return false;
                }
            }
            System.out.println("User not found");
            return false;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void deleteUser(String username) {
        try {
            Statement deleteStatement = networkDriver.network.createStatement();
            deleteStatement.executeUpdate("delete from UserTable where username='" + username + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }




    public void editUser(String oldUser, String newPassword, String newUser) {
        //create list of users
        deleteUser(oldUser);
        User editedUser = new User(newUser,newPassword);
        addUser(editedUser);
    }
}
