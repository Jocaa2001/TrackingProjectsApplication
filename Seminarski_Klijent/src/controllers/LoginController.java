/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import koordinator.Koordinator;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class LoginController {
    
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!validacija()) {
                    JOptionPane.showMessageDialog(lf,"Lozinka mora sadrzati:\n - Minimum 8 karaktera\n - Minimum jedno veliko slovo\n - Minimum jedan broj\n "
                            + "- Bar jedan specijalni karakter\n - Minimum jedan broj" );
                    return;
                }
                login();
            }

            private void login() {
                 String username = lf.getjTextFieldUsername().getText().trim();
                 String pass = String.valueOf(lf.getjPasswordField().getPassword());
                 
                 Komunikacija.getInstance().konekcija();
                 Profesor ulogovani = Komunikacija.getInstance().login(username,pass);
                 if(ulogovani == null){
                     JOptionPane.showMessageDialog(lf, "Систем не може да нађе професора по задатој вредности","Неуспех", JOptionPane.INFORMATION_MESSAGE);
                     
                 }else{
                      Koordinator.getInstance().setUlogovani(ulogovani);
                      JOptionPane.showMessageDialog(lf, "Успешно сте се пријавили на систем","Успех", JOptionPane.INFORMATION_MESSAGE);
                      lf.dispose();
                      koordinator.Koordinator.getInstance().otvoriGlavnuFormu();
                 }
                         
            }

            private boolean validacija() {
                String pass = String.valueOf(lf.getjPasswordField().getPassword());
                 Komunikacija.getInstance().konekcija();
                 boolean ispravan = Komunikacija.getInstance().validate(pass);
                 return ispravan;
            }
        });
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }
    
    
    
}
