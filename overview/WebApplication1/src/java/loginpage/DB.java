/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ALOK SINGH
 */
public class DB {
   // static Connection con;
    // static PreparedStatement ps;
    public  static String add(String name,String pass,String id,String pass1,String code) 
            throws ClassNotFoundException, SQLException
    {
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");
        
       
       //creating connection with the database
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/feedback","root","");
            PreparedStatement  ps=con.prepareStatement
                          ("insert into stu(username,pwd,Stuid,rpwd) values(?,?,?,?,?)");
            //out.println("hello world");
            
            // int id = Integer.parseInt(name);
            ps.setString(1,name);
            ps.setString(2, pass);
            ps.setString(3,id);
            ps.setString(4,pass1);
            ps.setString(5,code);
            int i=ps.executeUpdate();
            if(i>0)
            {
                return("You are sucessfully registered");  
            }
      // System.out.println("You are sucessfully registered");  
             return "data not inserted";
       // return "datanoinserted";
    }
     public  static boolean add0(String email, String code) 
            throws ClassNotFoundException, SQLException
    {
        //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");
        
       
       //creating connection with the database
                Connection con = DriverManager.getConnection ("jdbc:mysql://localhost:3306/feedback","root","");
            PreparedStatement  ps=con.prepareStatement("UPDATE stu "
                + "SET code = ? "
                + "WHERE rpwd = ?");
            //out.println("hello world");
            
            // int id = Integer.parseInt(name);
            ps.setString(1,code);
            ps.setString(2,email);
            int i=ps.executeUpdate();
            if(i>0)
            {
           System.out.println("updated"); 
             return true; 
            }
     System.out.println("registered");  
             return false;
       // return "datanoinserted";
    }
    public static void main(String[] args) throws ClassNotFoundException,SQLException
 {
     //DB obj3 = new DB();
     // DB obj4 = new DB();
     DB.add0("aloksingh4495@gmail.com","4321");
   // boolean sd=obj4.add0("1234");
  

}

    private static void add(String aloksingh4495gmailcom, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}