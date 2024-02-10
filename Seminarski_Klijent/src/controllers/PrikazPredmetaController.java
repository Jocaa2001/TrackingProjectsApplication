/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import forme.PrikazPredmetaForma;
import forme.table_model.ModelTabelePredmet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import model.Predmet;

/**
 *
 * @author Win 10
 */
public class PrikazPredmetaController {
    private final PrikazPredmetaForma ppf;

    public PrikazPredmetaController(PrikazPredmetaForma ppf) {
        this.ppf = ppf;
        addActionListeners();
    }

    private void addActionListeners() {
        ppf.obrisiPredmetActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTablePredmeti().getSelectedRow();
                if(red == -1){
                     JOptionPane.showMessageDialog(ppf, "Систем не може да нађе предмет по задатој вредности","Грешка", JOptionPane.INFORMATION_MESSAGE);
                     return;
                }else{
                     JOptionPane.showMessageDialog(ppf, "Систем је нашао предмет по задатој вредности","Грешка", JOptionPane.INFORMATION_MESSAGE);
                }
                ModelTabelePredmet mtp = (ModelTabelePredmet) ppf.getjTablePredmeti().getModel();
                Predmet p = mtp.getLista().get(red);
                
                try{
                 Komunikacija.getInstance().deletePredmet(p);
                 JOptionPane.showMessageDialog(ppf, "Систем је обрисао предмет", "Успех", JOptionPane.INFORMATION_MESSAGE);
                 pripremiFormu();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(ppf, "Систем није успео да обрише предмет", "Грешка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
    
    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
    }

    private void pripremiFormu() {
        List<Predmet> predmeti = komunikacija.Komunikacija.getInstance().loadListPredmet();
        ModelTabelePredmet mtp = new ModelTabelePredmet(predmeti);
        ppf.getjTablePredmeti().setModel(mtp);
                
    }

    public void sakrijDugmeObrisi() {
        ppf.getjButtonObrisi().setVisible(false);
    }
    
}
