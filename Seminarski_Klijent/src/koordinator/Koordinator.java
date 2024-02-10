/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koordinator;

import controllers.DodajStudentaController;
import controllers.GlavnaFormaController;
import controllers.LoginController;
import controllers.PrikazPredmetaController;
import controllers.PrikazStudenataController;
import forme.DodajStudentaForma;
import forme.GlavnaForma;
import forme.LoginForma;
import forme.PrikazPredmetaForma;
import forme.PrikazStudenataForma;
import mod.ModPredmet;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class Koordinator {
    private static Koordinator instance;
    private LoginController lc;
    private GlavnaFormaController gfc;
    private PrikazPredmetaController ppc;
    private PrikazStudenataController psc;
    private DodajStudentaController dsc;
    private Profesor ulogovani;
    private Koordinator() {
        
    }

public static Koordinator getInstance() {
        if(instance == null)
            instance = new Koordinator();
        return instance;
    }   

    public void otvoriLoginFormu() {
        lc = new LoginController(new LoginForma());
        lc.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        gfc = new GlavnaFormaController(new GlavnaForma());
        gfc.otvoriformu();
    }

    public Profesor getUlogovani() {
        return ulogovani;
    }

    public void otvoriPrikazStudentaFormu() {
        psc = new PrikazStudenataController(new PrikazStudenataForma());
        psc.otvoriFormu();
    }
    
    public void setUlogovani(Profesor ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriPrikazPredmetaFormu(ModPredmet m) {
        ppc = new PrikazPredmetaController(new PrikazPredmetaForma());
        if(m.equals(m.pronadji))
            ppc.sakrijDugmeObrisi();
        ppc.otvoriFormu();
    }

    public void otvoriDodajStudentaFormu() {
        dsc = new DodajStudentaController(new DodajStudentaForma());
        dsc.otvoriFormu();
    }

   

    
    
    
    
}
