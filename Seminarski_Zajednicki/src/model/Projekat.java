/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Student;

/**
 *
 * @author Win 10
 */
public class Projekat implements ApstraktniDomenskiObjekat {
    
    private Student student;
    private Predmet predmet;
    private Profesor profesor;
    private String tema;
    private int brojpoena;
    private Date rokPredaje;

    
    
    public Projekat(Student student, Predmet predmet, Profesor profesor, String tema, int brojpoena, Date rokPredaje) {
        this.student = student;
        this.predmet = predmet;
        this.profesor = profesor;
        this.tema = tema;
        this.brojpoena = brojpoena;
        this.rokPredaje = rokPredaje;
    }  

    public Projekat() {
    }

   public Date getRokPredaje() {
        return rokPredaje;
    }

    public void setRokPredaje(Date rokPredaje) {
        this.rokPredaje = rokPredaje;
    }
    

    public int getBrojpoena() {
        return brojpoena;
    }

    public void setBrojpoena(int brojpoena) {
        this.brojpoena = brojpoena;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public String vratiNazivTabele() {
        return "projekat";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "IDpredmet,IDstudent,IDprofesor,tema,brojPoena,rokPredaje";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        

        return String.format("(%d, %d, %d, '%s', %d, %tF)",
                predmet.getIdpredmet(), student.getIdstudent(), profesor.getIdprofesora(), tema, brojpoena, rokPredaje);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "IDpredmet = 2" + predmet.getIdpredmet() + " and IDstudent = " + student.getIdstudent();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatizRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return String.format("IDpredmet = %d, IDstudent = %d, IDprofesor = %d, tema = %s, brojPoena = %d, rokPredaje = %tF",
                predmet.getIdpredmet(), student.getIdstudent(), profesor.getIdprofesora(), tema, rokPredaje);
    }

    
    
    
    
}