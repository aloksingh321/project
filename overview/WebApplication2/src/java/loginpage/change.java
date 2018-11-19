/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;



import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;
//@WebServlet(urlPatterns={"/hjk"})
public class change extends HttpServlet {  
    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
         response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
          //  request.getRequestDispatcher("link.html").include(request, response);
            
            String name=request.getParameter("email");
            String pass=request.getParameter("pass2");
             String t=request.getParameter("token");
            boolean r;
            Validate obj = new Validate();
            if(r=obj.checkUser1(pass,name,t)){
               
            }
            else{
              
               
            }
        }  
        }        
      }  
  


