/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme.angazovanje;

import java.util.List;
import javax.swing.JOptionPane;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import validator.Validator;


/**
 *
 * @author Win 10
 */
public class DodajAngazovanjeForma extends javax.swing.JDialog {
    private Angazovanje angazovanje;
    private Angazovanje a;
    /**
     * Creates new form DodajAngazovanjeForma
     */
    public DodajAngazovanjeForma(java.awt.Frame parent, boolean modal,Angazovanje a) {
        super(parent, modal);
        initComponents();
        this.a = a;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        populateComboBoxes();
        pripremiFormu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNapomena = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxPredmet = new javax.swing.JComboBox<>();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonZapamti = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Napomena");

        jLabel2.setText("Profesor");

        jLabel3.setText("Predmet");

        jButtonKreiraj.setText("Kreiraj");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
            }
        });

        jButtonZapamti.setText("Zapamti");
        jButtonZapamti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZapamtiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxPredmet, 0, 134, Short.MAX_VALUE)
                    .addComponent(jComboBoxProfesor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldNapomena)
                    .addComponent(jButtonKreiraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonZapamti, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addComponent(jButtonKreiraj)
                .addGap(18, 18, 18)
                .addComponent(jButtonZapamti)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        
               Predmet pred = (Predmet) jComboBoxPredmet.getSelectedItem();
               Profesor prof = (Profesor) jComboBoxProfesor.getSelectedItem();
               String napomena = jTextFieldNapomena.getText();
               
              
                angazovanje = new Angazovanje(pred, prof, napomena);
                JOptionPane.showMessageDialog(this, "Систем је креирао ангажовање");

    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapamtiActionPerformed
        try {
                    komunikacija.Komunikacija.getInstance().saveAngazovanje(angazovanje);
                    JOptionPane.showMessageDialog(this, "Систем је запамтио ангажовање", "Успех", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    ex.printStackTrace();
                   JOptionPane.showMessageDialog(this, "Систем не може да запамти ангажовање", "Успех", JOptionPane.INFORMATION_MESSAGE);
                }
    }//GEN-LAST:event_jButtonZapamtiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JComboBox<Predmet> jComboBoxPredmet;
    private javax.swing.JComboBox<Profesor> jComboBoxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldNapomena;
    // End of variables declaration//GEN-END:variables

    private void populateComboBoxes() {
        List<Predmet> predmeti = controller.Controller.getInstance().loadListPredmeti();
        for (Predmet p : predmeti) {
            jComboBoxPredmet.addItem(p);
        }
        
        List<Profesor> profesori = controller.Controller.getInstance().loadListProfesor();
        for (Profesor p : profesori) {
            jComboBoxProfesor.addItem(p);
        }
    }

    private void pripremiFormu() {
        if(a != null){
            jComboBoxPredmet.setSelectedItem(a.getPredmet());
            jComboBoxProfesor.setSelectedItem(a.getProfesor());
            jTextFieldNapomena.setText(a.getNapomena());
            jComboBoxPredmet.setEditable(false);
            jComboBoxProfesor.setEditable(false);
            jTextFieldNapomena.setEditable(false);
            jComboBoxPredmet.setEnabled(false);
            jComboBoxProfesor.setEnabled(false);
            jTextFieldNapomena.setEnabled(false);
           
        }
        
    }
    
}
