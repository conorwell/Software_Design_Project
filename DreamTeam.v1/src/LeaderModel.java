import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class LeaderModel {

    public ArrayList<String> getFriends(String u){
        ArrayList<String> friendsArray = new ArrayList<>();
        File friendsList = new File("./FriendsLists/"+u+"_Friends.csv");

        try{
            Scanner senderListReader = new Scanner(friendsList);
            while (senderListReader.hasNextLine()) {
                String[] currentLine = senderListReader.nextLine().split(",");
                String friendName = currentLine[0];
                String friendStatus = currentLine[1];
                if (friendStatus.equals("friends")) {
                    friendsArray.add(friendName);
                }

            }
        }catch(FileNotFoundException e){System.out.println("File not found. No friends???");}


        return friendsArray;
    }

    public DefaultTableModel getWorkouts(String u,LeaderBoardGUI g){
        DefaultTableModel defTab = new DefaultTableModel(){ //creating table model
            @Override
            public boolean isCellEditable(int row, int column) { //declaring table is not editable
                //all cells false
                return false;
            }
        };


        ArrayList<String> friends = getFriends(u);
        File workouts = new File("workouts.csv"); //creating file to read from

        try { //reading csv file
            CSV_Parser read = new CSV_Parser();
            g.data = read.readCSV(workouts);

            for (int i = 0; i < g.data.size(); i++) {
                Vector row = new Vector();
                for (int j = 0; j < g.data.get(i).size(); j++) {
                    if (i == 0) {
                        defTab.addColumn(g.data.get(i).get(j));
                    } else {
                        if (!g.data.get(i).get(0).equals(u))
                            if(friends.contains(g.data.get(i).get(0))){
                                row.add(g.data.get(i).get(j));
                            }

                    }
                }
                if (i != 0) {
                    defTab.addRow(row); //adding data to table
                }

            }
        }catch(Exception e){
            System.out.println("It was this");
        }


        return defTab;
    }
}
