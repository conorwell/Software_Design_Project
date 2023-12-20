package Friends;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class FriendsGUI extends JFrame implements ActionListener {
    FriendsMain friendsMain = new FriendsMain();
    boolean friendsTableVisible;
    public FriendsGUI(String user){
        GridBagConstraints gbc = new GridBagConstraints();
        JFrame friendsFrame = new JFrame("Friends List");
        friendsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
                    friendsFrame.setVisible(false);
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
                    int requestSent = friendsMain.sendRequest(user,userToAdd);
                    switch((Integer) requestSent){
                        case 0:JOptionPane.showMessageDialog(null,"Sent friend request to "+userToAdd+".","Success",JOptionPane.INFORMATION_MESSAGE);break;
                        case 1:JOptionPane.showMessageDialog(null,"Error: You are already friends with this user.","Error",JOptionPane.ERROR_MESSAGE);break;
                        case 2:JOptionPane.showMessageDialog(null,"Error: You have already sent this user a friend request.","Error",JOptionPane.ERROR_MESSAGE);break;
                        case 3:JOptionPane.showMessageDialog(null,"Error: "+userToAdd+" has already sent you a friend request (accept below).","Error",JOptionPane.ERROR_MESSAGE);break;
                        case 4:JOptionPane.showMessageDialog(null,"Error: User "+userToAdd+" could not be found.","Error",JOptionPane.ERROR_MESSAGE);break;
                    }
                }}});

        DefaultTableModel friendsModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {return false;}};
        int friendCount=0; int requestCount=0;
        try{ArrayList<String> friendsArray = new ArrayList<>();
            ArrayList<String> requestsArray = new ArrayList<>();
            friendsModel.addColumn("<html><b>Friends:</b></html>");
            friendsModel.addColumn("<html><b>Requests:</b></html>");
            ArrayList<Vector> rows = new ArrayList<>();
            ArrayList<String> friendsData = friendsMain.getFriendsList(user);
            for(int i = 0;i<friendsData.size();i++) {
                String[] currentLine = friendsData.get(i).split(",");
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
            friendsTableVisible = true;
        }catch(Exception e){
            System.out.println("Table couldn't be created");
            friendsTableVisible = false;
        }
        JTable friendsTable = new JTable();
        friendsTable.setModel(friendsModel);
        friendsFrame.add(friendsTable);
        final int finalFriendCount=friendCount; final int finalRequestCount=requestCount;
        friendsTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int row = target.getSelectedRow();
                    int column = target.getSelectedColumn();
                    if(column==0&&row<finalFriendCount){
                        System.out.println("clicked a friend");
                        //friends user profile, remove friend option, and/or challenge option could go here
                    }else if(column==1&&row<finalRequestCount){
                        System.out.println("reeeee");
                        JOptionPane requestPane = new JOptionPane(friendsTable.getValueAt(row,column)+" sent you a friend request.");
                        Object[] requestButtons = { "Accept", "Reject" };
                        Object answer = JOptionPane.showOptionDialog(null, friendsTable.getValueAt(row,column)+" sent you a friend request.",
                                "Friend Request", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, requestButtons, requestButtons[0]);
                        switch ((Integer) answer){
                            case 0:friendsMain.acceptRequest(user,friendsTable.getValueAt(row,column).toString());
                                friendsFrame.setVisible(false);
                                FriendsGUI acceptRefreshGUI = new FriendsGUI(user);
                            case 1:friendsMain.denyRequest(user,friendsTable.getValueAt(row,column).toString());
                                friendsFrame.setVisible(false);
                                FriendsGUI denyRefreshGUI = new FriendsGUI(user);
                    }}}}});

        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(friendsTable);
        gbc.gridx = 0;gbc.gridy = 1;gbc.gridwidth = 3;
        friendsFrame.add(scroll,gbc);
        friendsFrame.pack();
        friendsFrame.setLocationRelativeTo(null);
        friendsFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {}
}