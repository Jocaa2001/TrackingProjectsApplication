/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.projekat;

import db.DBBroker;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ApstraktniDomenskiObjekat;
import model.Projekat;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class IzmeniProjekatOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
       if (!(ado instanceof Projekat)) {
          
            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
        }
        
       
        
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        Projekat p = (Projekat)ado;
        DBBroker.getInstance().delete(p);
        for (Student s : p.getListaStudenata()) {
            
            p.setStudent(s);
            
            DBBroker.getInstance().insert(p);
        }
          
    }
    
    
}
