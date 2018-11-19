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
            String []adds = {name};
             boolean r;
            check obj = new check();
            if(r=obj.checkUser(name)){
        Random rand = new Random();      
        int a = rand.nextInt(1000); 
       String l = Integer.toString(a);
         DB.add0(l);
          SendMailSSL.send(adds, "Verification Code", l); 
           request.getRequestDispatcher("index.html").include(request, response);
            }
            else{
                request.getRequestDispatcher("login_1.html").include(request, response); 
                 }
        } catch (ClassNotFoundException | SQLException ex) {
             Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
         }  
        }          
}
    

