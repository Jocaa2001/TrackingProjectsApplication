/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.db.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ApstraktniDomenskiObjekat;
import repository.db.DBConnectionFactory;
import repository.db.DbRepository;

/**
 *
 * @author Win 10
 */
public class DbRepositoryGeneric implements DbRepository<ApstraktniDomenskiObjekat> {

    @Override
    public List<ApstraktniDomenskiObjekat> pretraga(ApstraktniDomenskiObjekat param, String uslov) throws Exception {
         List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        String upit ="select * from " + param.vratiNazivTabele();
        if(uslov != null)
            upit+=uslov;
        System.out.println(upit);
        
        Statement st = DBConnectionFactory.getinstance().getConnection().createStatement();
        ResultSet rs = st.executeQuery(upit);
        lista = param.vratiListu(rs);
        
        
        rs.close();
        st.close();
        return lista;
    }

    @Override
    public void dodaj(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "insert into " +param.vratiNazivTabele()+" ("+param.vratiKoloneZaUbacivanje()+") values " + param.vratiVrednostiZaUbacivanje();
        System.out.println(upit + "OVO GLEDSAASSS");
        Statement st = DBConnectionFactory.getinstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void izmeni(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "update " + param.vratiNazivTabele() + " set " + param.vratiVrednostZaIzmenu();
        System.out.println(upit);
        Statement st = DBConnectionFactory.getinstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public void izbrisi(ApstraktniDomenskiObjekat param) throws Exception {
        String upit = "delete from " + param.vratiNazivTabele() + " where " + param.vratiPrimarniKljuc();
        Statement st = DBConnectionFactory.getinstance().getConnection().createStatement();
        st.executeUpdate(upit);
        st.close();
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiSve() {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        //String upit ="Select * "
        return lista;
    }
    
    
    
}
