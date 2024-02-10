/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.DodajStudentaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Student;

/**
 *
 * @author Win 10
 */
public class DodajStudentaController {
    
    private final DodajStudentaForma dsf;

    public DodajStudentaController(DodajStudentaForma dsf) {
        this.dsf = dsf;
        addActionListeners();
    }

    public void otvoriFormu() {
        dsf.setVisible(true);
    }

    private void addActionListeners() {
        dsf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = createStudent();
                dodaj(e,s);
            }

            private void dodaj(ActionEvent e, Student s) {
                if(s == null){
                    JOptionPane.showMessageDialog(null, "Систем не може да креира студента");
                    return;
                }
                    JOptionPane.showMessageDialog(null, "Систем је успешно креирао студента");
                try{
                Komunikacija.getInstance().dodajStudenta(s);
                JOptionPane.showMessageDialog(dsf, "Систем је успешно запамтио студента", "Успех", JOptionPane.INFORMATION_MESSAGE);
                
                dsf.dispose();
                
                }catch(Exception exc){
                     JOptionPane.showMessageDialog(dsf, "Систем не може да запамти студента", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }

            private Student createStudent() {
                 String ime = dsf.getjTextFieldIme().getText().trim();
                String prezime = dsf.getjTextFieldPrezime().getText().trim();
                int brInd = Integer.parseInt(dsf.getjTextFieldBrInd().getText());
                Student s = new Student(-1, ime, prezime, brInd);
                if(s.getIme() == null || s.getPrezime() == null || s.getIme().isEmpty() || s.getPrezime().isEmpty()|| String.valueOf(s.getBrojindeksa()).length() != 8){
                    
                    return null;
                }
                   return s;
            }
            
        });
    }
    
    
    
}
