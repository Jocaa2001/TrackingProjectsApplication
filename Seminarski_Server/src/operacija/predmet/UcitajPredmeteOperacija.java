/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.predmet;

import java.util.List;
import model.Predmet;
import model.Student;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Win 10
 */
public class UcitajPredmeteOperacija extends ApstraktnaGenerickaOperacija {

    private List<Predmet> predmeti; 
    
    @Override
    protected void preduslovi(Object objekat)throws Exception {
    }

    @Override
    protected void izvrsiOperaciju(Object objekat, String kljuc) throws Exception {
        predmeti = broker.pretraga(new Predmet(),"");
    }

    public List<Predmet> getPredmeti() {
        return predmeti;
    }
    
}
