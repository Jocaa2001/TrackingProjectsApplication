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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Student;

/**
 *
 * @author Win 10
 */
public class PrikazStudenataController {
    
    private final PrikazStudenataForma psf;

    public PrikazStudenataController(PrikazStudenataForma psf) {
        this.psf = psf;
        psf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addActionListeners();
    }

    private void addActionListeners() {
       psf.addPretraziDugmeActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               int brojIndeksa;
               if(psf.getjTextFieldBrInd().getText() == null ||psf.getjTextFieldBrInd().getText().isEmpty())
                   brojIndeksa = 0;
               else 
                   brojIndeksa = Integer.valueOf(psf.getjTextFieldBrInd().getText());
               String ime = psf.getjTextFieldIme().getText();
               String prezime = psf.getjTextFieldPrezime().getText();
               
                ModelTabeleStudent mts = (ModelTabeleStudent) psf.getjTableStudenti().getModel();
                mts.pretrazi(brojIndeksa, ime,prezime);
                if(mts.getLista().size() == 0)
                    JOptionPane.showMessageDialog(psf, "Систем не може да нађе студенте по задатим вредностима");
                else
                    JOptionPane.showMessageDialog(psf, "Систем је нашао студенте по задатим вредностима");
           }
       });
       psf.addResetujDugmeActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               pripremiFormu();
           }
       });
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
