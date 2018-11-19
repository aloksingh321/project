/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpage;

import javax.mail.MessagingException;

/**
 *
 * @author ALOK SINGH
 */
public class SendMailSSL {   
 
    private static final String from = "aloksingh.cse16@chitkarauniversity.edu.in";  // GMail user name (just the part before "@gmail.com")
    private static final String pass = "A$9889898529"; // GMail password
    private static  String RECIPIENT = "aloksingh4495@gmail.com";
    public static void send(String[] to, String subject, String body)
    {
                    Mailer.sendFromGMail(from, pass, to, subject, body);;
    }
    public static void main(String[] args) {
      
        String []s = {"aloksinghnhn@gmail.com"};
        send(s, "ABC", "4321");
    }   
}    

