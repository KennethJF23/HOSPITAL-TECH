package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame {

    Choice choice;
    JTable table;

    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel status = new JLabel("Status :");
        status.setBounds(50,73,120,20);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setForeground(Color.white);
        panel.add(status);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(250,11,186,31);
        For.setFont(new Font("Tahoma",Font.BOLD,20));
        For.setForeground(Color.white);
        panel.add(For);

        choice = new Choice();
        choice.setBounds(170,75,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);


        table = new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            conn c =new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel RoomNo = new JLabel("Room Number");
        RoomNo.setBounds(23,162,150,20);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RoomNo.setForeground(Color.white);
        panel.add(RoomNo);

        JLabel available = new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        available.setForeground(Color.white);
        panel.add(available);

        JLabel price = new JLabel("Price");
        price.setBounds(400,162,150,20);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setForeground(Color.white);
        panel.add(price);

        JLabel Bed = new JLabel("Bed Type");
        Bed.setBounds(580,162,150,20);
        Bed.setFont(new Font("Tahoma",Font.BOLD,14));
        Bed.setForeground(Color.white);
        panel.add(Bed);

        JButton Search = new JButton("Search");
        Search.setBounds(200,420,120,25);
        Search.setBackground(Color.black);
        Search.setForeground(Color.white);
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q ="select * from Room where Availability = '"+choice.getSelectedItem()+"'";
                try{
                    conn c =new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back = new JButton("Back");
        Back.setBounds(380,420,120,25);
        Back.setBackground(Color.black);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
