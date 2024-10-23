/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Win 10
 */
public interface ApstraktniDomenskiObjekat extends Serializable {
    
    public abstract String nazivTabele();
    public abstract String alijas();
    public abstract String join();
    public abstract ArrayList<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
    public abstract String koloneZaInsert();
    public abstract String vrednostZaPrimarniKljuc();
    public abstract String vrednostiZaInsert();
    public abstract String vrednostiZaUpdate();
    public abstract String getByID();
    
}
