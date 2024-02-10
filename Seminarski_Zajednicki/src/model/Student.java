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
public class Student implements ApstraktniDomenskiObjekat {
    
    private int idstudent;
    private String ime;
    private String prezime;
    private int brojindeksa;

    public Student(int idstudent, String ime, String prezime, int brojindeksa) {
        this.idstudent = idstudent;
        this.ime = ime;
        this.prezime = prezime;
        this.brojindeksa = brojindeksa;
    }

    public Student() {
    }

    
    
    public int getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(int idstudent) {
        this.idstudent = idstudent;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getBrojindeksa() {
        return brojindeksa;
    }

    public void setBrojindeksa(int brojindeksa) {
        this.brojindeksa = brojindeksa;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Student other = (Student) obj;
        return this.idstudent == other.idstudent;
    }

    @Override
    public String vratiNazivTabele() {
        return "student";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
         List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("student.IDstudent");
            String ime = rs.getString("student.ime");
            String prezime = rs.getString("student.prezime");
            int brIndeksa = rs.getInt("student.brojIndeksa");
            Student s = new Student(id,ime,prezime,brIndeksa);
            lista.add(s);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,brojIndeksa";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("('%s', '%s', %d)", ime, prezime, brojindeksa);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "student.IDstudent = "+ idstudent;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatizRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
         return String.format("ime = '%s', prezime = '%s', brojindeksa = %d ", ime, prezime,brojindeksa);
    }
    
    
}