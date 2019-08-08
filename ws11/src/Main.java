import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

public class Main {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    Main(){
        mainFrame = new JFrame("Accounts");
        mainFrame.setBounds(300, 100, 800, 100);
        mainFrame.setLayout(new FlowLayout());
        headerLabel = new JLabel("",JLabel.CENTER );
        statusLabel = new JLabel("",JLabel.CENTER);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception{
        Main swingControlDemo = new Main();
        swingControlDemo.showEventDemo();
    }

    public static void post(int id, String fname, String lname, double balance) throws Exception{
        int accid = id;
        String fName = fname;
        String lName = lname;
        double bal = balance;
        try {
            Connection con = getConnection();
            PreparedStatement posted = con.prepareStatement("INSERT INTO Accounts (id, first, last, balance) VALUES ('"+ accid + "', '"+ fName + "','"+ lName + "', '" + bal + "')");
            posted.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public static void createTable() throws Exception{
        try {
            Connection con = getConnection();
            PreparedStatement creat = con.prepareStatement("CREATE TABLE IF NOT EXISTS Accounts(id int NOT NULL,  first varchar(255) NOT NULL, last varchar(255) NOT NULL, balance double NOT NULL, PRIMARY KEY(id) ) ");
            creat.executeUpdate();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Creation Completed!");
        }
    }

    public static Connection getConnection() throws Exception{
        try {
            String url = "jdbc:mysql://localhost:3306/adb";
            String username = "root";
            String password = "rootpw";
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    void showEventDemo(){
        JLabel  Account= new JLabel("Account: ", JLabel.RIGHT);
        JLabel  FirstName= new JLabel("FName: ", JLabel.CENTER);
        JLabel  LastName= new JLabel("LName: ", JLabel.LEFT);
        JLabel  Balance= new JLabel("Balance: ", JLabel.LEFT);
        JButton submitButton = new JButton("Save");
        JButton getButton = new JButton("Search");
        final JTextField AccText = new JTextField(6);
        final JTextField FNameText = new JTextField(6);
        final JTextField LNameText = new JTextField(6);
        final JTextField BalText = new JTextField(6);
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Connection conn = getConnection();
                    PreparedStatement st = conn.prepareStatement("SELECT first, last , balance, id FROM Accounts");
                    ResultSet result = st.executeQuery();

                    JFrame newFrame = new JFrame();
                    JTextArea textArea = new JTextArea(10, 300);
                    newFrame.setBounds(300, 200, 800, 600);

                    textArea.append("=============A C C O U N T    D A T A=============\n\n");
                    textArea.append("Id" + "\t" + "First Name" + "\t" + "Last Name" + "\t" + "Balance\n\n");

                    while (result.next()) {
                        String id = result.getString("id");
                        String first = result.getString("first");
                        String last = result.getString("last");
                        String balance = result.getString("balance");
                        System.out.println(id + "\t" + first + "\t" + last + "\t" + balance + "\n");
                        textArea.append(id + "\t" + first + "\t" + last + "\t" + balance + "\n");
                        newFrame.add(textArea);
                        newFrame.setVisible(true);
                    }
                } catch(Exception e) {
                    System.out.println("error" + e);
                }
            }

        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    openConnection();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                try {
                    addRecord();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                AccText.setText("");
                FNameText.setText("");
                LNameText.setText("");
                BalText.setText("");
            }

            public void openConnection() throws Exception {
                getConnection();
            }

            public void addRecord() throws Exception {
                double balance= Double.parseDouble(BalText.getText());
                int access = Integer.parseInt(AccText.getText());
                post(access,FNameText.getText(),LNameText.getText(),balance);
            }
        });

        controlPanel.add(Account);
        controlPanel.add(AccText);
        controlPanel.add(FirstName);
        controlPanel.add(FNameText);
        controlPanel.add(LastName);
        controlPanel.add(LNameText);
        controlPanel.add(Balance);
        controlPanel.add(BalText);
        controlPanel.add(submitButton);
        controlPanel.add(getButton);
        mainFrame.setVisible(true);
    }
}