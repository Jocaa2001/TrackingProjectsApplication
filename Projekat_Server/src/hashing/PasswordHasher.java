/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Win 10
 */
public class PasswordHasher {
    
    private String pass;

    public PasswordHasher(String pass) {
        this.pass = pass;
    }
     
    public String hash(){
           StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pass.getBytes());
            byte[] digest = md.digest();
            for (int i = 0;i<digest.length;i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            } 
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(PasswordHasher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return hexString.toString();
    }
}
