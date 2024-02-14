/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import controllers.ControllerKlijent;
import static controllers.ControllerKlijent.ulogovaniAdmin;
import forme.DodajProfesoraForma;
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
        
        if(p != null){
            JOptionPane.showMessageDialog(null, "Успешно сте се пријавили на систем");
            ulogovaniAdmin = p;
            lif.dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Систем не може да нађе професора на основу датих вредности");
            
            }
        } catch (Exception ex) {
            Logger.getLogger(ControllerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        setLoggedIn();
        sf.pripremiFormu();
    }
    
    public void pripremiFormu(){
        if(ControllerKlijent.ulogovaniAdmin == null){
            sf.getjButtonDodajProfesora().setVisible(false);
            sf.getjTableIzmene().setVisible(false);
            sf.getJMenuBar().setEnabled(false);
            sf.getjMenuBar1().setEnabled(false);
            sf.getjButtonServer().setEnabled(false);
            sf.getjMenuItem1().setEnabled(false);
            sf.getjMenuItem2().setEnabled(false);
        }else{
            sf.getjButtonDodajProfesora().setVisible(true);
            sf.getjTableIzmene().setVisible(true);
            sf.getJMenuBar().setEnabled(true);
            sf.getjMenuBar1().setEnabled(true);
            sf.getjButtonServer().setEnabled(true);
            sf.getjMenuItem1().setEnabled(true);
            sf.getjMenuItem2().setEnabled(true);
        }
    }
    
   public void setLoggedIn(){
       sf.getjLabelProfesor().setText(ulogovaniAdmin.getIme());
   }
    
    public void otvoriLoginFormu() {
        lif = new LogInForma();
        lif.setVisible(true);
    }

   

   
   
   
    
}
