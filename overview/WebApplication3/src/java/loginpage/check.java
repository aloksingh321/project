/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ALOK SINGH
 */
public class check {
  public  boolean checkUser(String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/feedback","root","");
         Statement ps=con.createStatement();  
       String query="select * from stu where  rpwd='"+pass+"'";  
      // ps.setString(1, name);
        // ps.setString(2, pass);
         ResultSet rs =ps.executeQuery(query);
         while(rs.next())
         {
                String p=rs.getString("rpwd");
                if(p.equals(pass))
                {
                  // System.out.println("helloworld");
                 return true; 
               }
         }
        // st = rs.next();
      }catch(ClassNotFoundException | SQLException e)
      {
          e.printStackTrace();
      }
     // System.out.println(st);
         return st;                 
  }
    public static void main(String args[])
    {
       check obj = new check();
        obj.checkUser("aloksingh4495@gmail.com");
    }   
}
