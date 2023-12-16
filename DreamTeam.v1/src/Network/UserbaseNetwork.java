package Network;

import java.sql.*;

public class UserbaseNetwork{
    Connection network;
    public UserbaseNetwork(Connection network){
        this.network = network;
    }

    public void userList() {
        try {
            Statement searchStatement = network.createStatement();
            ResultSet searchSet = searchStatement.executeQuery("select * from UserTable");
            System.out.println("Current userbase:");
            while (searchSet.next()) {
                System.out.println(searchSet.getString("username") + ", " + searchSet.getString("password"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createUser(String username, String password) {
        try {
            Statement createStatement = network.createStatement();
            createStatement.executeUpdate("insert into UserTable values ('" + username + "','" + password + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser(String username) {
        try {
            Statement deleteStatement = network.createStatement();
            deleteStatement.executeUpdate("delete from UserTable where username='" + username + "'");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkLogin(String username, String password) {
        try {
            Statement loginStatement = network.createStatement();
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
}
