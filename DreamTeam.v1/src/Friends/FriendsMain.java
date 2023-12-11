package Friends;

import java.io.*;
import java.util.*;

public class FriendsMain {

    public static void createFriendsList(String username) {    //to be run when an account is created
        try {String listName = "./FriendsLists/" + username + "_Friends.csv";
            File friendsList = new File(listName);
            friendsList.getParentFile().mkdirs();
            friendsList.createNewFile();
        } catch (IOException e) {System.out.println("file couldn't be created");}
    }

    public static int sendRequest(String sendingUser,String recievingUser) {
        try{Scanner senderListReader = new Scanner(new File("./FriendsLists/"+sendingUser+"_Friends.csv"));
            while (senderListReader.hasNextLine()) {
                String[] friendUser = senderListReader.nextLine().split(",");
                if(friendUser[0].equals(recievingUser)){
                    if(friendUser[1].equals("friends")){
                        System.out.println("Case: you are already friends with this user");
                        return 1;
                    }else if(friendUser[1].equals("sent")){
                        System.out.println("Case: you have already sent this user a friend request");
                        return 2;
                    }else if(friendUser[1].equals("recieved")){
                        System.out.println("Case: user has already sent you a friend request");
                        //could either auto accept request or just tell the user to go to friends request page
                        return 3;}}}
            senderListReader.close();
            Scanner userbaseReader = new Scanner(new File("users./.csv")); //swap to master userbase
            while (userbaseReader.hasNextLine()) {
                String[] fileUser = userbaseReader.nextLine().split(",");
                if(fileUser[0].equals(recievingUser)){ //switch to fileUser[1] if file in password,username order
                    BufferedWriter requestWriter = new BufferedWriter(new FileWriter("./FriendsLists/"+fileUser[0]+"_Friends.csv",true));
                    requestWriter.write(sendingUser+",recieved"+"\n");
                    requestWriter.flush();requestWriter.close();
                    BufferedWriter requestSave = new BufferedWriter(new FileWriter("./FriendsLists/"+sendingUser+"_Friends.csv",true));
                    requestSave.write(fileUser[0]+",sent"+"\n");
                    requestSave.flush();requestSave.close();
                return 0;}}
        return 4;
    }catch(IOException e){}
        return 4;
    }

    public static void acceptRequest(String sendingUser,String recievingUser) {
        handleRequest(sendingUser,recievingUser,true);
        handleRequest(recievingUser,sendingUser,true);}
    public static void denyRequest(String sendingUser,String recievingUser){
        handleRequest(sendingUser,recievingUser,false);
        handleRequest(recievingUser,sendingUser,false);}

    public static void handleRequest(String sendingUser,String recievingUser,boolean accept){
        try{ArrayList<String> senderList = new ArrayList<>();
            int lineNum = 0;
            File handlerListFile = new File("./FriendsLists/"+sendingUser+"_Friends.csv");
            Scanner senderListReader = new Scanner(handlerListFile);
                while (senderListReader.hasNextLine()) {
                    String currentLine = senderListReader.nextLine();
                    String[] parsedLine = currentLine.split(",");
                    if(!(recievingUser.equals(parsedLine[0]))){ //again change to [1] if password,username format
                        senderList.add(lineNum,currentLine);lineNum++;}}
            senderListReader.close();
            handlerListFile.delete();
            BufferedWriter handlerWriter = new BufferedWriter(new FileWriter("./FriendsLists/"+sendingUser+"_Friends.csv"));
            for(int i=0;i<senderList.size();i++){
                handlerWriter.write(senderList.get(i)+"\n");handlerWriter.flush();}
            if(accept){handlerWriter.write(recievingUser+",friends\n");handlerWriter.flush();}
            handlerWriter.close();
        }catch(IOException e){}
    }

        public static void main (String[]args){
            FriendsMain friendsMain = new FriendsMain();
            //friendsMain.sendRequest("guest","big");
            //friendsMain.acceptRequest("big","bob");
            //friendsMain.denyRequest("guest","big");
    }

}

