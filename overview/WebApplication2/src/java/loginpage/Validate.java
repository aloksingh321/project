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
         Statement ps=con.createStatement();  
      
        String query="select * from stu where code='"+token+"'and rpwd='"+email+"'"; 
        String sql = "UPDATE stu SET pwd='"+pass+"' where code='"+token+"' and rpwd='"+email+"'";
         //String query1="select * from stu where rpwd='"+email+"'";
      // ps.setString(1, name);
        // ps.setString(2, pass);
        
        
        int  rs =ps.executeUpdate(sql);
       
        if(rs>0)
        {
            System.out.println("vggv");
        }
    
        //ResultSet rs1 =ps.executeQuery(query1);
        
            
             /* while(rs.next())
         {
          String u=rs.getString("code"); 
           String p=rs.getString("rpwd"); 
           if(u.equals(token))
           {
              
            System.out.println("aloksingh1");   
            return true;
           }
         }  */
        
       /*  while(rs1.next())
         {
         
             String p=rs1.getString("rpwd");
           //   System.out.println(u);
                if(p.equals(email))
                {
                System.out.println("aloksingh");
            // String sql = "UPDATE stu SET pwd='"+pass+"' where rpwd='"+email+"' ";
              
                 return true; 
               }
         }
*/        // st = rs.next();
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
        Validate.checkUser1("54321","aloksingh4495@gmail.com","321");
    }

    void checkUser(String aloksingh4495gamilcom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
