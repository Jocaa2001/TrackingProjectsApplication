/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.profesor;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ApstraktniDomenskiObjekat;
import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class LoadListProfesor extends ApstraktnaGenerickaOperacija {

    ArrayList<Profesor> lista;

    public ArrayList<Profesor> getLista() {
        return lista;
    }
    
    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Profesor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predmet!");
        }
    }

    @Override
    public void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> profesori = DBBroker.getInstance().select(ado);
         lista = (ArrayList<Profesor>) (ArrayList<?>) profesori;
    }
    
}
