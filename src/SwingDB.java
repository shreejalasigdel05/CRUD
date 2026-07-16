import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class SwingDB extends JFrame implements ActionListener{
    JLabel name, address, phone,course;
    JTextField txtname, txtaddress, txtphone,txtcourse;
    JButton register,clear;
    SwingDB(){
        name=new JLabel("Name: ");
        address=new JLabel("Address ");
        phone=new JLabel("Phone ");
        course=new JLabel("Course: ");

        txtname=new JTextField();
        txtaddress=new JTextField();
        txtphone=new JTextField();
        txtcourse=new JTextField();

        register=new JButton("Register");
        clear=new JButton("Clear");

        register.addActionListener(this);
        clear.addActionListener(this);

        setLayout(new GridLayout(4,2,10,10));

        add(name);
        add(txtname);

        add(address);
        add(txtaddress);

        add(phone);
        add(txtphone);

        add(register);
        add(clear);

        setTitle("Registration Form");
        setSize(320,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==register){
           String name=txtname.getText();
           String address=txtaddress.getText();
           long phone=Long.parseLong(txtphone.getText());
           String course=txtcourse.getText();
           try{
               String url = "jdbc:mysql://localhost:3307/collegedb1";
               String user = "root";
               String pass = "";
               Class.forName("com.mysql.cj.jdbc.Driver");
               Connection con = DriverManager.getConnection(url, user, pass);
               PreparedStatement ps1 = con.prepareStatement("INSERT INTO students(name,address,phone,course) VALUES (?,?,?,?)");
               ps1.setString(1, name);
               ps1.setString(2, address);
               ps1.setLong(3, phone);
               ps1.setString(4, course);
               ps1.executeUpdate();
               JOptionPane.showMessageDialog(null,"added");
           }catch (Exception ex){
               JOptionPane.showMessageDialog(null,"error");
           }
        if(e.getSource()==clear){
            txtname.setText("");
            txtaddress.setText("");
            txtphone.setText("");
            txtcourse.setText("");
        }
        }
    }
    public static void main(String[] args){
        new SwingDB();
    }
}

