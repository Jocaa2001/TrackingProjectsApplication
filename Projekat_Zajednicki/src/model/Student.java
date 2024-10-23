/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private int brojProjekata;

    public Student(int idstudent, String ime, String prezime, int brojindeksa) {
      //  this.p = p;
        this.idstudent = idstudent;
        this.ime = ime;
        this.prezime = prezime;
        this.brojindeksa = brojindeksa;
    }

    public Student() {
    }

    public int getBrojProjekata() {
        
        return brojProjekata;
    }

    public void setBrojProjekata(int brojProjekata) {
        this.brojProjekata = brojProjekata;
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
    public String nazivTabele() {
        return "student";
    }

    @Override
    public String alijas() {
        return "stud";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("stud.IDstudent");
            String ime = rs.getString("stud.ime");
            String prezime = rs.getString("stud.prezime");
            int brIndeksa = rs.getInt("stud.brojIndeksa");
            Student s = new Student(id,ime,prezime,brIndeksa);
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
         return "ime,prezime,brojIndeksa";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return "stud.IDstudent = "+ idstudent;
    }

    @Override
    public String vrednostiZaInsert() {
        return String.format("('%s', '%s', %d)", ime, prezime, brojindeksa);
    }

    @Override
    public String vrednostiZaUpdate() {
       return String.format("ime = '%s', prezime = '%s', brojindeksa = %d ", ime, prezime,brojindeksa);
    }

    @Override
    public String getByID() {
        return "";
    }

    
    
    
}