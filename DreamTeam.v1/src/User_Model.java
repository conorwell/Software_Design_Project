import Network.NetworkDriver;
import Network.UserbaseNetwork;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_Model {

    NetworkDriver networkDriver = new NetworkDriver();
    UserbaseNetwork userbaseNetwork = new UserbaseNetwork(networkDriver.network);

    public void addUser(String password, String user, String filePath){
        List<List<String>> users = getUsers(filePath);
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
            writer.write(user+ "," + password);
            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    //TODO Replace with actual algorithm

    public ArrayList<ArrayList<String>> getUsers(String filePath) {
        ArrayList<ArrayList<String>> userList = new ArrayList<ArrayList<String>>();
        try {
            Statement searchStatement = networkDriver.network.createStatement();
            ResultSet searchSet = searchStatement.executeQuery("select * from UserTable");
            //System.out.println("Current userbase:");
            while (searchSet.next()) {
                System.out.println(searchSet.getString("username") + ", " + searchSet.getString("password"));
                ArrayList<String> userID = new ArrayList<>();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //create ArrayList of users+passwords
        //List<List<String>> users_array = new ArrayList<>();

        //Read each line of csv file
        //try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            //String line;

            //split lines by commas to separate user+password
            //while ((line = br.readLine()) != null) {
                //String[] values = line.split(",");
                //users_array.add(Arrays.asList(values));
            //}
        //}
        //catch(IOException e){
            //e.printStackTrace();
        //}
        //return users_array;


    }

    public boolean approveUser(String username, String password, String filepath){
        //get list of all users
        //List<List<String>> users = getUsers(filepath);
        if(userbaseNetwork.checkLogin(username,password)){
        //get specific user
        //for (List<String> user : users)
            //if (user.get(0).equals(password) && user.get(1).equals(username)) {
                return true;
            }
        return false;
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
