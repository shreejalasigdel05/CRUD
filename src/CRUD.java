import java.sql.*;
import java.util.Scanner;
public class CRUD {
    static String url = "jdbc:mysql://localhost:3306/collegedb1";
    static String user = "root";
    static String pass = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Display");
            System.out.println("4. Delete");
            System.out.println("Enter Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter course: ");
                    String course = sc.nextLine();

                    PreparedStatement ps1 = con.prepareStatement("INSERT INTO students(name,address,phone,course) VALUES (?,?,?,?)");
                    ps1.setString(1, name);
                    ps1.setString(2, address);
                    ps1.setString(3, phone);
                    ps1.setString(4, course);
                    ps1.executeUpdate();

                    System.out.println("Data entered successfully");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Address: ");
                    address = sc.nextLine();

                    System.out.print("Enter New Phone: ");
                    phone = sc.nextLine();

                    System.out.print("Enter New Course: ");
                    course = sc.nextLine();

                    PreparedStatement ps2 = con.prepareStatement("UPDATE students SET name=?,address=?,phone=?,course=?, WHERE id=?");
                    ps2.setString(1, name);
                    ps2.setString(2, address);
                    ps2.setString(3, phone);
                    ps2.setString(4, course);
                    ps2.setInt(5, id);
                    ps2.executeUpdate();

                    System.out.println("Record Updated");
                    break;

                case 3:
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM students");

                    System.out.println("\nID\tName\tAddress\tPhone\tEmail");
                    while (rs.next()) {
                        System.out.println(
                                rs.getInt("id") + "\t" +
                                        rs.getString("name") + "\t" +
                                        rs.getString("address") + "\t" +
                                        rs.getString("phone") + "\t" +
                                        rs.getString("email"));
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    PreparedStatement ps3 = con.prepareStatement(
                            "DELETE FROM students WHERE id=?");
                    ps3.setInt(1, id);
                    ps3.executeUpdate();

                    System.out.println("Record Deleted");
                    break;

                default:
                    System.out.println("Invalid Choice");

            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        sc.close();
    }
}