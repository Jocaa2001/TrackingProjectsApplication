/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.DodajProfesoraForma;
import hashing.PasswordHasher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Profesor;
import model.Zvanje;
import operacija.profesor.DodajProfesoraOperacija;
import sun.security.util.Password;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class DodajProfesoraController {
    private static DodajProfesoraController instance;
    public DodajProfesoraForma dpf;

    private DodajProfesoraController() {
        dpf = new DodajProfesoraForma();
        dpf.setVisible(true);
        populateComboBox();
        addActionListeners();
    }

    public static DodajProfesoraController getInstance() {
        if(instance == null)
            instance = new DodajProfesoraController();
        return instance;
    }
    
    
    
    

    private void addActionListeners() {
        dpf.setActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = dpf.getjTextFieldime().getText();
                String prezime = dpf.getjTextFieldimePrezime().getText();
                String username = dpf.getjTextFieldUsername().getText();
                String password = String.valueOf(dpf.getjPasswordField().getPassword());
                Zvanje z = (Zvanje) dpf.getjComboBoxZvanje().getSelectedItem();
                
                
                if(Validator.validatorPassworda(password) && Validator.validatorImena(ime) && Validator.validatorPrezimena(prezime)){
                    password = new PasswordHasher(password).hash();
                    JOptionPane.showMessageDialog(dpf, "Систем је креирао професора");
                    
                }
                else{
                    JOptionPane.showMessageDialog(dpf, "Систем не може да креира професора");
                    return;
                }
                
                Profesor p = new Profesor(-1, ime, prezime, z, password, username);
                DodajProfesoraOperacija operacija = new DodajProfesoraOperacija();
                
                try {
                    operacija.izvrsi(p, null);
                    JOptionPane.showMessageDialog(dpf, "Систем је запамтио професора");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dpf, "Систем не може да запамти професора");
                }
                
            }
        });
    }

    private void populateComboBox() {
        
        for (Zvanje z : Zvanje.values()) {
           
            dpf.getjComboBoxZvanje().addItem(z);
        }
    }
    
}
