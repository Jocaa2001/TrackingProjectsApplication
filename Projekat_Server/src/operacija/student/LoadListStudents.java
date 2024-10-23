/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.student;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class LoadListStudents extends ApstraktnaGenerickaOperacija {

    ArrayList<Student> lista;
    
    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Student)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Student!");
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> usluge = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Student>) (ArrayList<?>) usluge;
    }

    public List<Student> getLista() {
        return lista;
    }
    
    
    
}
