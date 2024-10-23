/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import model.Student;

/**
 *
 * @author Win 10
 */
public class Projekat implements ApstraktniDomenskiObjekat {
    
    private int id;
    private List<Student> listaStudenata;
    private Student student;
    private Predmet predmet;
    private Profesor profesor;
    private String tema;
    private int brojpoena;
    private Date rokPredaje;

    
    
    public Projekat(Predmet predmet, Profesor profesor, String tema, int brojpoena, Date rokPredaje,List<Student> listaStudenata, int id) {
        this.id = id;
        //this.student = student;
        this.predmet = predmet;
        this.profesor = profesor;
        this.tema = tema;
        this.brojpoena = brojpoena;
        this.rokPredaje = rokPredaje;
        this.listaStudenata = listaStudenata;
    }  

    public Projekat(int id, List<Student> listaStudenata, Student student, Predmet predmet, Profesor profesor, String tema, int brojpoena, Date rokPredaje) {
        this.id = id;
        this.listaStudenata = listaStudenata;
        this.student = student;
        this.predmet = predmet;
        this.profesor = profesor;
        this.tema = tema;
        this.brojpoena = brojpoena;
        this.rokPredaje = rokPredaje;
    }
    
    
    
    public Projekat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getListaStudenata() {
        return listaStudenata;
    }

    public void setListaStudenata(List<Student> listaStudenata) {
        this.listaStudenata = listaStudenata;
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
    public String nazivTabele() {
        return "projekat";
    }

    @Override
    public String alijas() {
        return "proj";
    }

    @Override
    public String join() {
         return "JOIN student stud ON proj.IDstudent = stud.IDstudent " +
           "JOIN predmet pred ON proj.IDpredmet = pred.IDpredmet " +
           "JOIN profesor prof ON proj.IDprofesor = prof.IDprofesor";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
    
    while (rs.next()) {
        
        
        
        
        String tema = rs.getString("proj.tema");
        int brojPoena = rs.getInt("proj.brojPoena");
        Date dat = rs.getDate("proj.rokPredaje");
        
        Student stud = new Student(rs.getInt("stud.IDstudent"), rs.getString("stud.ime"),rs.getString("stud.prezime"), rs.getInt("Stud.brojIndeksa"));
       
        
        Profesor prof = new Profesor(rs.getInt("prof.IDprofesor"), rs.getString("prof.ime"),rs.getString("prof.prezime"),Zvanje.valueOf(rs.getString("prof.zvanje")),
                                    rs.getString("prof.password"),rs.getString("prof.username"));
        
        Predmet pred = new Predmet(rs.getInt("pred.IDpredmet"), rs.getInt("pred.espb"), rs.getString("pred.naziv"), rs.getInt("pred.obavezan") == 1);
        
        int id = rs.getInt("proj.id");
        
        Projekat projekat = new Projekat(pred, prof, tema, brojPoena, dat,null, id);
        projekat.setStudent(stud);
        lista.add(projekat);
    }
    
    return lista;
    }

    @Override
    public String koloneZaInsert() {
         return "IDpredmet,IDstudent,IDprofesor,tema,brojPoena,rokPredaje, id";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "id = " + id;
    }

    @Override
    public String vrednostiZaInsert() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String formatiranDatum = sdf.format(rokPredaje);
        
        
       System.out.println("Vrednosti za insert:");
    System.out.println("IDpredmet: " + predmet.getIdpredmet());
    System.out.println("IDstudent: " + student.getIdstudent());
    System.out.println("IDprofesor: " + profesor.getIdprofesora());
    System.out.println("Tema: " + tema);
    System.out.println("Broj poena: " + brojpoena);
    System.out.println("Rok predaje: " + formatiranDatum);
    System.out.println("ID: " + id);
        
        
        return String.format("(%d,%d, %d, '%s', %d, '%s', %d)",
                predmet.getIdpredmet(),student.getIdstudent(), profesor.getIdprofesora(), tema, brojpoena, formatiranDatum, id);
    }

    @Override
    public String vrednostiZaUpdate() {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String formatiranDatum = sdf.format(rokPredaje);
         return String.format("IDpredmet = %d, IDprofesor = %d, tema = '%s', brojPoena = %d, rokPredaje = '%s', id = %d ",
                predmet.getIdpredmet(), profesor.getIdprofesora(), tema,brojpoena, formatiranDatum, id);
    }

    @Override
    public String getByID() {
        return "";
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Projekat other = (Projekat) obj;
        if (!Objects.equals(this.tema, other.tema)) {
            return false;
        }
        if (!Objects.equals(this.student, other.student)) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        return Objects.equals(this.profesor, other.profesor);
    }

public String toString() {
    return "Projekat{" +
           "id=" + id +
           ", tema='" + tema + '\'' +
           ", brojpoena=" + brojpoena +
           ", rokPredaje=" + rokPredaje +
           ", student=" + (student != null ? student.getIme() + " " + student.getPrezime() : "null") +
           ", predmet=" + (predmet != null ? predmet.getNaziv() : "null") +
           ", profesor=" + (profesor != null ? profesor.getIme() + " " + profesor.getPrezime() : "null") +
           '}';
}
    
}