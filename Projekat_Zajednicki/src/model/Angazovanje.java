/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Win 10
 */
public class Angazovanje implements ApstraktniDomenskiObjekat {
    
    private Predmet predmet;
    private Profesor profesor;
    private String napomena;

    public Angazovanje() {
    }

    public Angazovanje(Predmet predmet, Profesor profesor,String napomena) {
        this.predmet = predmet;
        this.profesor = profesor;
        this.napomena = napomena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String nazivTabele() {
        return "angazovanje";
    }

    @Override
    public String alijas() {
        return "ang";
    }

    @Override
    public String join() {
        return "JOIN predmet pred ON ang.IDpredmeta = pred.IDpredmet " +
           "JOIN profesor prof ON ang.IDprofesor = prof.IDprofesor";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
           
            Profesor prof = new Profesor(rs.getInt("prof.IDprofesor"), rs.getString("prof.ime"),rs.getString("prof.prezime"),Zvanje.valueOf(rs.getString("prof.zvanje")),
                                    rs.getString("prof.password"),rs.getString("prof.username"));
        
            Predmet pred = new Predmet(rs.getInt("pred.IDpredmet"), rs.getInt("pred.espb"), rs.getString("pred.naziv"), rs.getInt("pred.obavezan") == 1);
             
            Angazovanje a = new Angazovanje(pred, prof, rs.getString("ang.napomena"));
            
            lista.add(a);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "IDprofesor,IDpredmeta,napomena";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "ang.IDprofesor = "+profesor.getIdprofesora()+ " AND ang.IDpredmeta = " + predmet.getIdpredmet();
    }

    @Override
    public String vrednostiZaInsert() {
        return String.format("(%d, %d, '%s')", profesor.getIdprofesora(), predmet.getIdpredmet(), napomena);
    }

    @Override
    public String vrednostiZaUpdate() {
        return String.format("IDpredmeta = %d , IDprofesor = %d,napomena = '%s'", predmet.getIdpredmet(),profesor.getIdprofesora(),napomena);
    }

    @Override
    public String getByID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Angazovanje other = (Angazovanje) obj;
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        return Objects.equals(this.profesor, other.profesor);
    }

    
   
    
}