package Network;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NetworkDriver {
    public Connection network;

    public NetworkDriver(){
        startUp();
    }

    public void startUp() {
        try {Class.forName("com.mysql.cj.jdbc.Driver");
            network = DriverManager.getConnection(
                    "jdbc:mysql://localhost:8889/mysql", "root", "root");
                                //Connection steps:
                                //establish a new DB browser connection at host:localhost, username:root, password:root
                                //replace '8889' with your port if not connecting through mamp (in both connection and code above)
                                //replace 'dreamteamv1' with your local database name
            Statement createStatement = network.createStatement();
            createStatement.executeUpdate("create table if not exists UserTable (username varchar(50),password varchar(50));");
        }catch(Exception e){
            System.out.println(e);
            System.exit(2);
        }
    }
}