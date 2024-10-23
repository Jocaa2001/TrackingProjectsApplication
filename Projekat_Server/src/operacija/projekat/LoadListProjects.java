/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.projekat;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ApstraktniDomenskiObjekat;
import model.Projekat;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class LoadListProjects extends ApstraktnaGenerickaOperacija{

    ArrayList<Projekat> lista;

    public ArrayList<Projekat> getLista() {
        return lista;
    }
    
    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if (!(ado instanceof Projekat)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> usluge = DBBroker.getInstance().select(ado);
        
        lista = (ArrayList<Projekat>) (ArrayList<?>) usluge;
       
    }
    
}
