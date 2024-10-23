/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.projekat;

import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class SaveProject extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if (!(ado instanceof Projekat)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
        }
        
        Projekat p = (Projekat) ado;
    
        // da li postoji projekat
        ArrayList<ApstraktniDomenskiObjekat> projekti = DBBroker.getInstance().select(p);
        for (ApstraktniDomenskiObjekat proj : projekti) {
            if(((Projekat) proj).equals(p)){
                throw new Exception("Prosledjeni projekat vec postoji");
            }
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        
       
        int projekatID = getNextAvailableId();
        
     
         Projekat p = (Projekat) ado;
        p.setId(projekatID);
        
        for (Student s : p.getListaStudenata()) {
           
           
            p.setStudent(s);
            DBBroker.getInstance().insert(p);
        }
        
    }

    private int getNextAvailableId() {
        
        try {
             String query = "SELECT MAX(id) FROM Projekat";
            Statement stmt = DBBroker.getInstance().getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
        return rs.getInt(1) + 1;  // Vrati sledeći slobodan ID
    } else {
        return 1;  // Ako nema ID-jeva, počni od 1
    }
        } catch (SQLException ex) {
            Logger.getLogger(SaveProject.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}
