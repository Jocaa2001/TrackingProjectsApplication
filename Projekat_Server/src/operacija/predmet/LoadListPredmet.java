/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.predmet;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import model.Predmet;
import model.Profesor;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class LoadListPredmet extends ApstraktnaGenerickaOperacija {

    ArrayList<Predmet> lista;
    
    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
        if (!(ado instanceof Predmet)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predmet!");
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> predmeti = DBBroker.getInstance().select(ado);
         lista = (ArrayList<Predmet>) (ArrayList<?>) predmeti;
    }

    public ArrayList<Predmet> getLista() {
        return lista;
    }
    
}
