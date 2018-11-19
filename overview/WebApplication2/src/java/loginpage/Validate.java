/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ALOK SINGH
 */
public class Validate {
    public  boolean checkUser(String name,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/feedback","root","");
         Statement ps=con.createStatement();  
       String query="select * from stu where username='"+name+"' and pwd='"+pass+"'";  
      // ps.setString(1, name);
        // ps.setString(2, pass);
         ResultSet rs =ps.executeQuery(query);
         while(rs.next())
         {
          String u=rs.getString("username");
                String p=rs.getString("pwd");
                if(u.equals(name) && p.equals(pass))
                {
                   System.out.println("helloworld");
                 return true; 
               }
         }
        // st = rs.next();
      }catch(ClassNotFoundException | SQLException e)
      {
          e.printStackTrace();
      }
      System.out.println(st);
         return st;                 
  }
  public static  boolean checkUser1(String pass,String email,String token) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/feedback","root","");
         PreparedStatement  ps=con.prepareStatement("UPDATE stu "
                + "SET pwd = ? "
                +"WHERE code=?");
            //out.println("hello world");
            
            // int id = Integer.parseInt(name);
            ps.setString(1,pass);
           // ps.setString(2,email);
            ps.setString(2,token);
  
        int  rs =ps.executeUpdate();
       
        if(rs>0)
        {
            System.out.println("password sucessfully updated");
        }
    
              }catch(ClassNotFoundException | SQLException e)
      {
          e.printStackTrace();
      }
      System.out.println(st);
         return st;                 
  }
  
    
    public static void main(String args[])
    {
       // Validate obj = new Validate();
       // obj.checkUser("alok","singh");
        Validate.checkUser1("6543","aloksingh4495@gmail.com","4321");
    }

    void checkUser1(String aloksingh4495gamilcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
