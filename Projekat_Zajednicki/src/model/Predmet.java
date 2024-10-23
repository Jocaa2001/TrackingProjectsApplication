/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Win 10
 */
public class Predmet implements ApstraktniDomenskiObjekat {
    
    private int idpredmet;
    private int espb;
    private String naziv;
    private boolean obavezan;

    public Predmet(int idpredmet, int espb, String naziv, boolean obavezan) {
        this.idpredmet = idpredmet;
        this.espb = espb;
        this.naziv = naziv;
        this.obavezan = obavezan;
    }

    public Predmet() {
    }

    public int getIdpredmet() {
        return idpredmet;
    }

    public void setIdpredmet(int idpredmet) {
        this.idpredmet = idpredmet;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public boolean isObavezan() {
        return obavezan;
    }

    public void setObavezan(boolean obavezan) {
        this.obavezan = obavezan;
    }

    @Override
    public String toString() {
        return naziv;
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
        final Predmet other = (Predmet) obj;
        if (this.idpredmet != other.idpredmet) {
            return false;
        }
        if (this.espb != other.espb) {
            return false;
        }
        if (this.obavezan != other.obavezan) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String nazivTabele() {
        return "predmet";
    }

    @Override
    public String alijas() {
        return "pred";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("pred.IDpredmet");
            int espbpoeni = rs.getInt("pred.espb");
            
            String naziv = rs.getString("pred.naziv");
            int o = rs.getInt("pred.obavezan");
            boolean obavezan = o == 1;
            
            Predmet p = new Predmet(id, espbpoeni, naziv, obavezan);
            
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return "espb,naziv,obavezan";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "predmet.IDpredmet = " + idpredmet;
    }

    @Override
    public String vrednostiZaInsert() {
        int obavezanInt = obavezan ? 1 : 0;
        return String.format("(%d, '%s', %d)", espb, naziv, obavezanInt);
    }

    @Override
    public String vrednostiZaUpdate() {
        int obavezanInt = obavezan ? 1 : 0;
        return String.format("espb = %d, naziv = '%s', obavezan = %d", espb, naziv, obavezanInt);
    }

    @Override
    public String getByID() {
        return "";
    }

    
    
    
}