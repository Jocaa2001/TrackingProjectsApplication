/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.DodajStudentaForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Student;
import validator.Validator;

/**
 *
 * @author Win 10
 */
public class DodajStudentaController {
    
    private final DodajStudentaForma dsf;
    private Student student;

    public DodajStudentaController(DodajStudentaForma dsf) {
        this.dsf = dsf;
        addActionListeners();
    }

    public void otvoriFormu() {
        dsf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dsf.setVisible(true);
    }

    private void addActionListeners() {
        dsf.ZapamtiAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                dodaj(e,student);
            }

            private void dodaj(ActionEvent e, Student s) {
                try{
                Komunikacija.getInstance().saveStudent(s);
                JOptionPane.showMessageDialog(dsf, "Систем је запамтио студента", "Успех", JOptionPane.INFORMATION_MESSAGE);
                dsf.dispose();
                
                }catch(Exception exc){
                     JOptionPane.showMessageDialog(dsf, "Систем не може да запамти студента", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }

            
            
        });
        dsf.kreirajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    createStudent();
                }
            private void createStudent() {
                 String ime = dsf.getjTextFieldIme().getText().trim();
                 String prezime = dsf.getjTextFieldPrezime().getText().trim();
                 String brojind = dsf.getjTextFieldBrInd().getText();
                 if(Validator.validatorImena(ime) && Validator.validatorPrezimena(prezime)&& Validator.validatorBrojIndeksa(brojind)){
                    
                 Student s = new Student(-1, ime, prezime, Integer.valueOf(brojind));
                 student = s;
                 
                 }else
                 student = null;
                 
                 System.out.println("ovo je student" + student);
                 if(student == null){
                    JOptionPane.showMessageDialog(null, "Систем не може да креира студента");
                    
                }else
                    JOptionPane.showMessageDialog(null, "Систем је успешно креирао студента");
            }
            
        });
    }
    
    
    
}
