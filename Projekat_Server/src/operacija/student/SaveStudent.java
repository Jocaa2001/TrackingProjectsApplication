/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.student;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ApstraktniDomenskiObjekat;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class SaveStudent extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if (!(ado instanceof Student)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Student!");
        }
        
        Student stud = (Student) ado;
        
        ArrayList<Student> studenti = (ArrayList<Student>)(ArrayList<?>) DBBroker.getInstance().select(ado);
        
        for (Student s : studenti) {
            if(s.getBrojindeksa() == stud.getBrojindeksa()){
                throw new Exception("vec postoji student sa tim indeksom");
            }
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        DBBroker.getInstance().insert(ado);
    }
    
}
