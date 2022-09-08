import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;

public class Bank {
String name;
String username;
String password;
int id;

    public static void main(String[] args){
       Bank stanbic = new Bank();
       if(stanbic.login()){
          //Customer user1 = new Customer("Brian", "Shikwekwe", "Savings Account", "savingsaccount01");
          Customer user2 = new Customer("Donovan","mitchel","checkings account","checkingsacc1");
          user2.registerClient();
       } else {
        System.out.println("not found");
       }
    }

    void register(){
        Scanner in = new Scanner(System.in);
            System.out.println("Enter your name");
            name = in.nextLine();
            System.out.println("Enter your username");
            username = in.nextLine();
            System.out.println("Enter password");
            password = in.nextLine();
            System.out.println("Enter id");
            id = in.nextInt();
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking-system-db","root","");
            Statement stmt = conn.createStatement();
            String sql = "insert into Admin(id,name,username,password) values('"+id+"','"+name+"','"+username+"','"+password+"')";
            stmt.executeUpdate(sql);System.out.println("connected to database....");
            System.out.println("....Data inserted succesfully");
            

              } catch (Exception e){System.out.println(e);}
               }

       boolean login (){
        boolean isAvailable = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your username");
        username = in.nextLine();
        System.out.println("Enter your password");
        password = in.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking-system-db","root","");
            Statement stmt = conn.createStatement();
            String sql = "select * from Admin where username='"+username+"' && password='"+password+"'";
             ResultSet rs = stmt.executeQuery(sql);
             if(rs.next()){
                return isAvailable = true;
             } else {
                return isAvailable = false;
             }
        } catch (Exception e){System.out.println(e);} 
        return isAvailable;
       }

            }

     

