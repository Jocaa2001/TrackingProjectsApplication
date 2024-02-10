/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        return naziv + " " + espb + " " + idpredmet ;
    }

    @Override
    public String vratiNazivTabele() {
        return "predmet";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("predmet.IDpredmet");
            int espbpoeni = rs.getInt("predmet.espb");
            
            String naziv = rs.getString("naziv");
            int o = rs.getInt("obavezan");
            boolean obavezan = o == 1 ? true:false;
            
            Predmet p = new Predmet(id, espbpoeni, naziv, obavezan);
            
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "espb,naziv,obavezan";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        int obavezanInt = obavezan ? 1 : 0;
        return String.format("(%d, '%s', %d)", espb, naziv, obavezanInt);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "predmet.IDpredmet = " + idpredmet;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatizRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
         int obavezanInt = obavezan ? 1 : 0;
         return String.format("espb = %d, naziv = '%s', obavezan = %d", espb, naziv, obavezanInt);
    }
    
    
    
}