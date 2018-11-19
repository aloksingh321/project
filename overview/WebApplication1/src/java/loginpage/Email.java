/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author ALOK SINGH
 */
public class Email extends HttpServlet {

     @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
         response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
          //  request.getRequestDispatcher("link.html").include(request, response);  
            String name=request.getParameter("email");
           // String []adds = {name};
           String t=name;
             boolean r;
            check obj = new check();
            if(r=obj.checkUser(name)){
              // out.println("alok");
        Random rand = new Random();      
        int a = rand.nextInt(1000); 
       String l = Integer.toString(a);
         DB.add0(name,l);
          SendMailSSL.send(t, "Verification Code", l); 
          request.getRequestDispatcher("check.html").include(request, response);
            }
            else{
                out.println("Sorry your invalid email Id");
                 out.println("Try again");
               request.getRequestDispatcher("forget.html").include(request, response); 
                 }
        } catch (ClassNotFoundException | SQLException | RuntimeException | MessagingException ex) {
             Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
         }  
        }          
}
    

