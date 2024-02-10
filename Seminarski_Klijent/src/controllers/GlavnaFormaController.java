/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import forme.GlavnaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import koordinator.Koordinator;
import model.Profesor;
import model.Projekat;

/**
 *
 * @author Win 10
 */
public class GlavnaFormaController {
    
    private final GlavnaForma gf;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    

    public void otvoriformu() {
        Profesor ulogovani = Koordinator.getInstance().getUlogovani();
        String imePrezime = ulogovani.getIme() + " " + ulogovani.getPrezime();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
    }

    private void addActionListeners() {
        
    }
    
    
    
    
}
