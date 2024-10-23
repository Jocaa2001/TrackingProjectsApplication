/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.angazovanje;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Angazovanje;
import model.ApstraktniDomenskiObjekat;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class DodajAngazovanjeOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
         if (!(ado instanceof Angazovanje)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Angazovanje!");
        }
         
         Angazovanje ang = (Angazovanje) ado;
        
         ArrayList<Angazovanje> angazovanja = (ArrayList<Angazovanje>)(ArrayList<?>) DBBroker.getInstance().select(ado);
         
         for (Angazovanje a : angazovanja) {
            if(ang.getPredmet().getIdpredmet() == a.getPredmet().getIdpredmet() && ang.getProfesor().getIdprofesora() == a.getProfesor().getIdprofesora()){
                    throw new Exception("U bazi postoji angazovanje sa istim parametrima");
        }
         
    }

    }
    @Override
    public void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
         DBBroker.getInstance().insert(ado);
         }
    }
    

