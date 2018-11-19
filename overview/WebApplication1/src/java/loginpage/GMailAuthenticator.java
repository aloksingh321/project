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
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 *
 * @author shobhit
 */
public class GMailAuthenticator extends Authenticator{
  
    String user;
    String pw;
    public GMailAuthenticator(String username,String password){
        super();
        this.user = username;
        this.pw = password; 
    }
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(user,pw);
    }
}