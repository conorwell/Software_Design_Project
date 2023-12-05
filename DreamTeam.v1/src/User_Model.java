import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_Model {


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

    public List<List<String>> getUsers(String filePath) {
        //create ArrayList of users+passwords
        List<List<String>> users_array = new ArrayList<>();

        //Read each line of csv file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            //split lines by commas to separate user+password
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                users_array.add(Arrays.asList(values));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return users_array;
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
