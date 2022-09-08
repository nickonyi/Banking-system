import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;

public class Customer {
    //properties
    String firstName;
    String surName;
    String accountName;
    String accountNumber;
    
    Customer(String aFirsName,String aSurName,String aAccountName,String aAccountNumber){
     firstName = aFirsName;
     surName = aSurName;
     accountName = aAccountName;
     accountNumber = aAccountNumber;
 
    }

    void registerClient(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking-system-db","root","");
            Statement stmt = conn.createStatement();
            String sql = "insert into customer() values('"+firstName+"','"+surName+"','"+accountName+"','"+accountNumber+"')";
            stmt.executeUpdate(sql);
            } catch (Exception e){System.out.println(e);}
     }

     void depositMoney(){
        
     }
}
