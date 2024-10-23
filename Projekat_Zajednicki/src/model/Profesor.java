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
public class Profesor implements ApstraktniDomenskiObjekat {
    
    private int idprofesora;
    private String ime;
    private String prezime;
    private Zvanje zvanje;
    private String password;
    private String username;
    
    
    public Profesor(int idprofesora, String ime, String prezime, Zvanje zvanje,String password, String username) {
        this.idprofesora = idprofesora;
        this.ime = ime;
        this.prezime = prezime;
        this.zvanje = zvanje;
        this.password = password;
        this.username = username;
    }

    public Profesor(String password, String username) {
        this.password = password;
        this.username = username;
    }
    
    

    public Profesor() {
    }

    public int getIdprofesora() {
        return idprofesora;
    }

    public void setIdprofesora(int idprofesora) {
        this.idprofesora = idprofesora;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanje(Zvanje zvanje) {
        this.zvanje = zvanje;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return  ime + " " + prezime;
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.username, other.username);
    }

    @Override
    public String nazivTabele() {
        return "profesor";
    }

    @Override
    public String alijas() {
        return "prof";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
         ArrayList<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("prof.IDprofesor");
            String i = rs.getString("prof.ime");
            String prez = rs.getString("prof.prezime");
            String z = rs.getString("prof.zvanje");
            Zvanje zv = Zvanje.valueOf(z);
            String pass = rs.getString("prof.password");
            String u = rs.getString("prof.username");
            
            Profesor p = new Profesor(id, i, prez, zv, pass,u);
            
            lista.add(p);
            
            
        }
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "ime,prezime,zvanje,password, username";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
         return "profesor.IDprofesor = " + idprofesora;
    }

    @Override
    public String vrednostiZaInsert() {
        return String.format("('%s', '%s', '%s', '%s', '%s')", ime, prezime, String.valueOf(zvanje), password, username);
    }

    @Override
    public String vrednostiZaUpdate() {
        return String.format("ime = '%s', prezime = '%s',zvanje = '%s',password = '%s', username = '%s'", ime, prezime, String.valueOf(zvanje), password,username);
    }

    @Override
    public String getByID() {
        return "";
    }
    
    
    
}