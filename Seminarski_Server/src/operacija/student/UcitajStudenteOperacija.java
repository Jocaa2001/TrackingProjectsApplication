/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.student;

import java.util.List;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class UcitajStudenteOperacija extends ApstraktnaGenerickaOperacija {

    private List<Student> studenti;
    
    @Override
    protected void preduslovi(Object objekat) {
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        studenti = broker.pretraga(new Student(),"");
        
    }

    public List<Student> getStudenti() {
        return studenti;
    }
    
}
