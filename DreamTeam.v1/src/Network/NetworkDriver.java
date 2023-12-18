package Network;

import java.sql.Connection;
import java.sql.DriverManager;

public class NetworkDriver {
    public Connection network;

    public NetworkDriver(){
        startUp();
    }

    public void startUp() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            network = DriverManager.getConnection("jdbc:mysql://localhost:8889/dreamteamv1",
                    "root", "root"); //this is to connect to master network
                                                            //requires user authentication + same wifi
            //network = DriverManager.getConnection("jdbc:mysql://localhost:8889/yourDataBaseNameHere,
                    //"root", "root"); //this is test with a locally created mamp database
        }catch(Exception e){
            System.out.println(e);
            //TODO: handle failure to connect to network
        }
    }

    //public static void main(String[] args) {
        //NetworkDriver networkConnection = new NetworkDriver();
        //networkConnection.startUp();
        //UserbaseNetwork userNetwork = new UserbaseNetwork(networkConnection.network);
        //userNetwork.createUser("Test","test");
        //userNetwork.userList();
        //userNetwork.checkLogin("Test","test");
        //userNetwork.deleteUser("Test");
        //userNetwork.checkLogin("Test","test");
        //userNetwork.checkLogin("Admin","reee");
        //userNetwork.checkLogin("Guest","guest");
        //userNetwork.userList();}
}