/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.predmet;

import db.DBBroker;
import java.sql.SQLException;
import model.ApstraktniDomenskiObjekat;
import model.Predmet;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class DeletePredmet extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if (!(ado instanceof Predmet)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Predmet!");
        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
        DBBroker.getInstance().delete(ado);
    }
    
}
