/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.ResultSet;
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
    public String vratiNazivTabele() {
        return "profesor";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("profesor.IDprofesor");
            String i = rs.getString("profesor.ime");
            String prez = rs.getString("profesor.prezime");
            String z = rs.getString("profesor.zvanje");
            Zvanje zv = Zvanje.valueOf(z);
            String pass = rs.getString("profesor.password");
            String u = rs.getString("profesor.username");
            
            Profesor p = new Profesor(id, i, prez, zv, pass,u);
            
            lista.add(p);
            
            
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ime,prezime,zvanje,password, username";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return String.format("('%s', '%s', '%s', '%s', '%s')", ime, prezime, String.valueOf(zvanje), password, username);
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "profesor.IDprofesor = " + idprofesora;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatizRS(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostZaIzmenu() {
        return String.format("ime = '%s', prezime = '%s',zvanje = '%s',password = '%s', username = '%s'", ime, prezime, String.valueOf(zvanje), password,username);
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return Objects.equals(this.username, other.username);
    }
    
    
    
}