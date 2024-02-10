/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.student;

import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class DodajStudentaOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object objekat) throws Exception {
        if(objekat == null || !(objekat instanceof Student)){
            throw new Exception("Систем не може да креира студента");
        }
        Student s = (Student) objekat;
        if(s.getIme() == null || s.getPrezime() == null || s.getIme().isEmpty() || s.getPrezime().isEmpty()|| String.valueOf(s.getBrojindeksa()).length() != 8){
             throw new Exception("Грешка, неисправан унос");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.dodaj((Student) objekat);
    }
    
}
