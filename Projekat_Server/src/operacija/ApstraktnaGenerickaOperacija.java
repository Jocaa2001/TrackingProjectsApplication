/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacija;

//import db.DBBroker;
import db.DBBroker;
import model.ApstraktniDomenskiObjekat;
import java.sql.SQLException;
import model.ApstraktniDomenskiObjekat;

/**
 *
 * @author PC
 */
public abstract class ApstraktnaGenerickaOperacija {

    public void templateExecute(ApstraktniDomenskiObjekat ado) throws Exception {
        try {
            preduslovi(ado);
            izvrsi(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    protected abstract void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception;
    protected abstract void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException;

    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
