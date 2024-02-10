/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.predmet;

import model.Predmet;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class ObrisiPredmetOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object objekat)throws Exception{
        if(objekat == null || !(objekat instanceof Predmet)){
            throw new Exception("Sistem nije mogao da obrise predmet");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        broker.izbrisi((Predmet) objekat);
    }
    
}
