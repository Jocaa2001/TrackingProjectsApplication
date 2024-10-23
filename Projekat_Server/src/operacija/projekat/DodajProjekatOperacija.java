/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.projekat;

import db.DBBroker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DodajProjekatOperacija extends ApstraktnaGenerickaOperacija{

    @Override
    protected void preduslovi(ApstraktniDomenskiObjekat ado) throws Exception {
//          if (!(ado instanceof Projekat)) {
//               System.out.println("\nOVDE1");
//            throw new Exception("Prosledjeni objekat nije instanca klase Projekat!");
//             
//        }
//        
//        Projekat proj = (Projekat) ado;
//        
//        ArrayList<Projekat> projekti = (ArrayList<Projekat>)(ArrayList<?>) DBBroker.getInstance().select(ado);
//        
//        for (Projekat p : projekti) {
//            if(p.getStudent().equals(proj.getStudent())&&p.getProfesor().equals(proj.getProfesor())&&p.getPredmet().equals(proj.getPredmet())){
//                System.out.println("\nOVDE2");
//                throw new Exception("Prosledjeni projekat vec postoji!");
//            }
//        }
    }

    @Override
    protected void izvrsi(ApstraktniDomenskiObjekat ado) throws SQLException {
            PreparedStatement ps = DBBroker.getInstance().insert(ado);
        System.out.println("\nOVDE3");
        ResultSet tableKeys = ps.getGeneratedKeys();
        System.out.println("\nOVDE4");
        tableKeys.next();
        System.out.println("\nOVDE5");
        int projekatID = tableKeys.getInt(1);
        System.out.println("\nOVDE6");
        Projekat p = (Projekat) ado;
        p.setId(projekatID);
        System.out.println("\nOVDE7");
        for (Student s : p.getListaStudenata()) {
            //s.setP(p);
            DBBroker.getInstance().insert(s);
            System.out.println("\nOVDE8");
        }
        
    
    }
    
}
