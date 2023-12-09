package Friends;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FriendsGUI extends JFrame implements ActionListener {
    public FriendsGUI(String user){
        GridBagConstraints gbc = new GridBagConstraints();
        JFrame friendsFrame = new JFrame("Friends List");
        friendsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        friendsFrame.setLayout(new GridBagLayout());
        gbc.insets =new Insets(5,5,5,5);

        JButton exitButton = new JButton("Exit");
        gbc.gridx = 0;gbc.gridy = 0;gbc.gridwidth = 1;
        exitButton.setPreferredSize(new Dimension(70,40));
        friendsFrame.add(exitButton, gbc);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==exitButton){
                    System.out.println("exit time");
                    //return to home screen
                }}});

        JButton addButton = new JButton("Add Friend");
        addButton.setPreferredSize(new Dimension(140,40));
        gbc.gridx = 1;gbc.gridy = 0;gbc.gridwidth = 1;
        friendsFrame.add(addButton, gbc);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==addButton){
                    String userToAdd = (JOptionPane.showInputDialog(null, "Enter a user to add as a friend:","Add Friend",JOptionPane.INFORMATION_MESSAGE));
                    System.out.println(userToAdd);
                    boolean requestSent = FriendsMain.sendRequest(user,userToAdd);
                    if(!requestSent){
                        System.out.println("this will be updated with cases for user already sent request, user already in friends list");
                        JOptionPane.showMessageDialog(null,"User "+userToAdd+" could not be found.","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }}});

        File friendsList = new File("./FriendsLists/"+user+"_Friends.csv");
        DefaultTableModel friendsModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {return false;}};
        int friendCount=0; int requestCount=0;
        try{ArrayList<String> friendsArray = new ArrayList<>();
            ArrayList<String> requestsArray = new ArrayList<>();
            Scanner senderListReader = new Scanner(friendsList);
            friendsModel.addColumn("<html><b>Friends:</b></html>");
            friendsModel.addColumn("<html><b>Requests:</b></html>");
            ArrayList<Vector> rows = new ArrayList<>();
            while (senderListReader.hasNextLine()) {
                String[] currentLine = senderListReader.nextLine().split(",");
                String friendName = currentLine[0];
                String friendStatus = currentLine[1];
                if (friendStatus.equals("friends")) {
                    friendsArray.add(friendName);
                    friendCount++;
                }else if(friendStatus.equals("recieved")){
                    requestsArray.add(friendName);
                    requestCount++;
                }
            }
            for(int i=0;i<friendCount||i<requestCount;i++){
                Vector vector = new Vector();
                try{vector.add(friendsArray.get(i));}catch(IndexOutOfBoundsException e){vector.add(" ");}
                try{vector.add(requestsArray.get(i));}catch(IndexOutOfBoundsException e){vector.add(" ");}
                friendsModel.addRow(vector);
            }
        }catch(FileNotFoundException e){System.out.println("Table couldn't be created");}
        JTable friendsTable = new JTable();
        friendsTable.setModel(friendsModel);
        friendsFrame.add(friendsTable);
        final int finalFriendCount=friendCount; final int finalRequestCount=0;
        friendsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    if(column==0){
                        System.out.println("clicked a friend");
                        //friends user profile, remove friend option, and/or challenge option could go here
                    }else if(column==1){
                        System.out.println("reeeee");
                        JOptionPane requestPane = new JOptionPane(friendsTable.getValueAt(row,column)+" sent you a friend request.");
                        Object[] requestButtons = { "Accept", "Reject" };
                        Object answer = JOptionPane.showOptionDialog(null, friendsTable.getValueAt(row,column)+" sent you a friend request.",
                                "Friend Request", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, requestButtons, requestButtons[0]);
                        switch ((Integer) answer){
                            case 0:FriendsMain.acceptRequest(user,friendsTable.getValueAt(row,column).toString());
                                System.out.println("Table wont update so will have to load to main screen then back in");
                            //refresh page, probably by switching to home screen and back
                    }}}}});

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(friendsTable);
        gbc.gridx = 0;gbc.gridy = 1;gbc.gridwidth = 3;
        friendsFrame.add(scroll,gbc);

        //friendsFrame.setPreferredSize(new Dimension(500,550));
        friendsFrame.pack();
        friendsFrame.setLocationRelativeTo(null);
        friendsFrame.setVisible(true);
    }


    public static void main(String[] args) {
        FriendsGUI f = new FriendsGUI("big");
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}