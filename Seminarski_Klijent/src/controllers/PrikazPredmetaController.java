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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import mod.ModPredmet;
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
                 //pripremiFormu();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(ppf, "Систем није успео да обрише предмет", "Грешка", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        ppf.addBtnPretraziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int espb;
            if(ppf.getjTextFieldEspb().getText() == null || ppf.getjTextFieldEspb().getText().isEmpty())
                espb = 0;
            else 
                espb = Integer.valueOf(ppf.getjTextFieldEspb().getText()); 
             String naziv = ppf.getjTextFieldNaziv().getText(); 
             ModelTabelePredmet mtp = (ModelTabelePredmet) ppf.getjTablePredmeti().getModel();
             if(ppf.getjComboBox1().getSelectedIndex() == -1 || ppf.getjComboBox1().getSelectedIndex() == 2)
             mtp.pretraziNoBool(espb, naziv);
             else{
             boolean obavezan = ppf.getjComboBox1().getSelectedItem().equals("Da");
             mtp.pretrazi(espb,naziv,obavezan);    
              }
             if(mtp.getLista().size() == 0)
                JOptionPane.showMessageDialog(ppf, "Систем не може да нађе предмете по задатим вредностима");
             else
                JOptionPane.showMessageDialog(ppf, "Систем је нашао предмете по задатим вредностима");
             
             
            }
        });
        ppf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              osveziFormu();
            }
        });
        
    }
    
    public void otvoriFormu(ModPredmet m) {
        ppf.setVisible(true);
        ppf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pripremiFormu(m);
    }

    public void pripremiFormu(ModPredmet m) {
        System.out.println(m);
        switch (m) {
            case obrisi:
                ppf.getjButtonObrisi().setVisible(true);
                break;
                
            case pronadji:
                ppf.getjButtonObrisi().setVisible(false);
                break;
            default:
                throw new AssertionError();
        }
        
        
        osveziFormu();
                
    }    
    
    public void osveziFormu(){
        List<Predmet> predmeti = komunikacija.Komunikacija.getInstance().loadListPredmet();
        ModelTabelePredmet mtp = new ModelTabelePredmet(predmeti);
        ppf.getjTablePredmeti().setModel(mtp);
    }
}
