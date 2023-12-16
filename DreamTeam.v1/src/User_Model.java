import Network.NetworkDriver;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_Model {
    NetworkDriver networkDriver = new NetworkDriver();

    public void addUser(String username, String password){
        try {
            Statement createStatement = networkDriver.network.createStatement();
            createStatement.executeUpdate("insert into UserTable values ('" + username + "','" + password + "')");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public List<List<String>> getUsers(String filePath) {
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




    public void editUser(String oldPassword, String oldUser, String newPassword, String newUser, String filePath) {
        //create list of users
        List<List<String>> users = getUsers(filePath);

        //find user being edited, change entry in ArrayList
        for(int i =0; i<users.size();i++){
            if(users.get(i).get(0).equals(oldUser) && users.get(i).get(1).equals(oldPassword)){
                users.get(i).set(0,newUser);
                users.get(i).set(1,newPassword);
            }
        }
        //write edited list to csv file
        File userFile = new File(filePath);
        try{
            // create FileWriter object with file as parameter
            FileWriter writer = new FileWriter(userFile);

            // add data to csv
            if(users.size() > 0) {
                for (int i = 0; i < users.size(); i++) {
                    writer.write(users.get(i).get(0) + "," + users.get(i).get(1) + "\n");
                }
            }
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
