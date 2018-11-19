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
  public static  boolean checkUser1(String pass,String email,String token) throws SQLException, ClassNotFoundException 
     {
      boolean st =false;
      

	
         Class.forName("com.mysql.jdbc.Driver");

 	
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/feedback?allowMultiQueries=true","root","");
     Statement ps=con.createStatement();  
       String query="select * from stu where rpwd='"+email+"' and code='"+token+"'";  
         ResultSet rs =ps.executeQuery(query);
         while(rs.next())
         {
          String u=rs.getString("rpwd");
                String p=rs.getString("code");  
        if(u.equals(email) && p.equals(token))
         {
         PreparedStatement  ps1=con.prepareStatement("UPDATE stu "
                + "SET pwd = ? "
                +"WHERE code=?");
            
            ps1.setString(1,pass);
            ps1.setString(2,token);
          int  a =ps1.executeUpdate();     
        if(a>0)
        {
            System.out.println("password sucessfully updated");
            return true;
        }
         }
              }
        
      System.out.println(st);
         return st;                 
  }
  
    
    public static void main(String args[]) throws SQLException, ClassNotFoundException
    {
       // Validate obj = new Validate();
       // obj.checkUser("alok","singh");
        Validate.checkUser1("54321","shobhit.s1813@gmail.com","35");
    }

    void checkUser1(String aloksingh4495gamilcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
