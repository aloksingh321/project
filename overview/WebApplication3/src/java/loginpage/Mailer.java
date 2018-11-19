/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;
/**
 *
 * @author ALOK SINGH
 */
  
  import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.*;
public class Mailer {
    
    public static void  send1(String from,String pass,String to, String sub,String msg)throws RuntimeException, AddressException, MessagingException{
        
    
    {
 
        
        Properties props =  new Properties();
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "587");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "587");   
          props.put("mail.smtp.starttls.enable", "true");
          
          Session session = Session.getInstance(props,
                  new GMailAuthenticator(from,pass){
                     PasswordAuthentication p =  getPasswordAuthentication();
                  }
             );
          
            MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);    
           //send message  
           Transport.send(message);    
           System.out.println("message sent successfully");    
        }
    }

    static void send(String from, String pass, String[] to, String subject, String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void send1(String from, String pass, String[] to, String subject, String body) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
