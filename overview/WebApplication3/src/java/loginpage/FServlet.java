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
public class FServlet extends HttpServlet {  
    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
         response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
          //  request.getRequestDispatcher("link.html").include(request, response);
            
            String name=request.getParameter("name");
            String pass=request.getParameter("pass");
           
            boolean r;
            Validate obj = new Validate();
            if(r=obj.checkUser(name,pass)){
                out.print("Welcome, "+name);
            request.getRequestDispatcher("link.html").include(request, response);
                HttpSession session=request.getSession();
                session.setAttribute("name",name);  
            }
            else{
                 request.getRequestDispatcher("login_1.html").include(request, response);
                 out.println(r);
                out.println("<p style=color:white>sorry, username or password error!</p>");
               
            }
        }  
        }        
      }  
  


