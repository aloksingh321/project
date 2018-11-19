package loginpage;

import java.io.*;  
import java.sql.*;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import loginpage.DB;
  
public class Register extends HttpServlet {  
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String p=request.getParameter("pass");  
String e=request.getParameter("pass1");  
String c=request.getParameter("id"); 

  DB obj = new DB();
    try { 
   String s= obj.add(n,p,c,e);
   out.println(s);
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
    }
}  
}