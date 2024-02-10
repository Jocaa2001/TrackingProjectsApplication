/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Server;

import controller.klijent.ControllerLogin;
import static controller.klijent.ControllerLogin.ulogovaniAdmin;
import forme.LogInForma;
import forme.ServerskaForma;
import hashing.PasswordHasher;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Profesor;
import operacija.login.LoginOperacija;

/**
 *
 * @author Win 10
 */
public class ControllerServer {

    private static ControllerServer instance;
    private LogInForma lif;
    private ServerskaForma sf;
    
    private ControllerServer() {
        sf = new ServerskaForma();
        sf.setVisible(true);
        sf.pripremiFormu();
    }

    public static ControllerServer getInstance() {
        if(instance == null){
            instance = new ControllerServer();
        }
        return instance;
    }
    
     public void login() {
        String username = lif.getjTextFieldUser().getText();
        String password = String.valueOf(lif.getjPasswordField().getPassword());
        password = new PasswordHasher(password).hash();
        login(username, password);
        
    }

    private void login(String username, String password) { //login sa serverske strane
        try {
       
        Profesor p = new Profesor(password, username);
        LoginOperacija lo = new LoginOperacija();
        lo.izvrsi(p, null);
        p = lo.getProf();
            System.out.println(p);
        if(p != null){
            JOptionPane.showMessageDialog(null, "Успешно сте се пријавили на систем");
            ulogovaniAdmin = p;
            lif.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Систем не може да нађе професора на основу датих вредности");
            
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLoggedIn();
        sf.pripremiFormu();
    }
    
   public void setLoggedIn(){
       sf.getjLabelProfesor().setText(ulogovaniAdmin.getIme());
   }
    
    public void otvoriLoginFormu() {
        lif = new LogInForma();
        lif.setVisible(true);
    }

   
   
   
    
}
