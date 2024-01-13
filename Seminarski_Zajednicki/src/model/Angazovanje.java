/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.time.Year;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Win 10
 */
public class Angazovanje implements ApstraktniDomenskiObjekat {
    
    private Predmet predmet;
    private Profesor profesor;
    private int godina;

    public Angazovanje() {
    }

    public Angazovanje(Predmet predmet, Profesor profesor, int godina) {
        this.predmet = predmet;
        this.profesor = profesor;
        this.godina = godina;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
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
    public String vratiNazivTabele() {
        return "angazovanje";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "IDprofesor,IDpredmeta,Godina";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("(%d, %d, %d)", profesor.getIdprofesora(), predmet.getIdpredmet(), godina);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "angazovanje.IDprofesor = "+profesor.getIdprofesora()+ " AND angazovanje.IDpredmeta = " + predmet.getIdpredmet();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatizRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return String.format("IDpredmeta = %d , IDprofesor = %d,godina = %d", predmet.getIdpredmet(),profesor.getIdprofesora(),godina);
    }

   
    
}