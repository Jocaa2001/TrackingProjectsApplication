/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.PrikazStudenataForma;
import forme.table_model.ModelTabeleStudent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import model.Student;

/**
 *
 * @author Win 10
 */
public class PrikazStudenataController {
    
    private final PrikazStudenataForma psf;

    public PrikazStudenataController(PrikazStudenataForma psf) {
        this.psf = psf;
        addActionListeners();
    }

    private void addActionListeners() {
       
    }

    public void otvoriFormu() {
        pripremiFormu();
        psf.setVisible(true);
    }

    public void pripremiFormu() {
        List<Student> studenti = komunikacija.Komunikacija.getInstance().loadListStudent();
        ModelTabeleStudent mts = new ModelTabeleStudent(studenti);
        psf.getjTableStudenti().setModel(mts);
    }
    
    
    
    
}
