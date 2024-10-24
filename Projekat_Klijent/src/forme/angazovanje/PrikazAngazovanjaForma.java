/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme.angazovanje;

import forme.tableModel.ModelTabeleAngazovanja;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;

/**
 *
 * @author Win 10
 */
public class PrikazAngazovanjaForma extends javax.swing.JDialog {

    /**
     * Creates new form PrikazAngazovanjaForma
     */
    public PrikazAngazovanjaForma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         populateForm();
         setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAngazovanje = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxPredmet = new javax.swing.JComboBox<>();
        jButtonPretrazi = new javax.swing.JButton();
        jButtonResetuj = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableAngazovanje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAngazovanje);

        jLabel1.setText("Profesor");

        jLabel2.setText("Predmet");

        jButtonPretrazi.setText("Pretrazi");
        jButtonPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPretraziActionPerformed(evt);
            }
        });

        jButtonResetuj.setText("Resetuj");
        jButtonResetuj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetujActionPerformed(evt);
            }
        });

        jButton1.setText("Detalji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPretrazi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonResetuj)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPretrazi)
                    .addComponent(jButtonResetuj))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetujActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetujActionPerformed
            refresh();
    }//GEN-LAST:event_jButtonResetujActionPerformed

    private void jButtonPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPretraziActionPerformed
       
        Profesor prof = (Profesor) jComboBoxProfesor.getSelectedItem();
        Predmet pred = (Predmet) jComboBoxPredmet.getSelectedItem();
       // String napomena = jTextFieldGodina.getText();
        
        System.out.println(prof);
        System.out.println(pred);
        
        ModelTabeleAngazovanja mta = (ModelTabeleAngazovanja) jTableAngazovanje.getModel();
        mta.pretrazi(prof, pred);
        
        jTableAngazovanje.setModel(mta);
            if(mta.getLista().size() == 0)
                    JOptionPane.showMessageDialog(this, "Систем не може да нађе ангажовања по задатим вредностима");
                else
                    JOptionPane.showMessageDialog(this, "Систем је нашао ангажовања по задатим вредностима");
        
        
         
        
    }//GEN-LAST:event_jButtonPretraziActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
       int red = jTableAngazovanje.getSelectedRow();
       
       if(red == -1){
           JOptionPane.showMessageDialog(this, "Одаберите ангажовање из табеле");
           return;
       }
        ModelTabeleAngazovanja mta = (ModelTabeleAngazovanja) jTableAngazovanje.getModel();
        
       Angazovanje a = mta.getLista().get(red);
       
       new DodajAngazovanjeForma(null, true, a).setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonPretrazi;
    private javax.swing.JButton jButtonResetuj;
    private javax.swing.JComboBox<Predmet> jComboBoxPredmet;
    private javax.swing.JComboBox<Profesor> jComboBoxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAngazovanje;
    // End of variables declaration//GEN-END:variables

    public void populateForm() {
        List<Predmet> predmeti = controller.Controller.getInstance().loadListPredmeti();
        for (Predmet p : predmeti) {
            jComboBoxPredmet.addItem(p);
        }
        
        List<Profesor> profesori = controller.Controller.getInstance().loadListProfesor();
        for (Profesor p : profesori) {
            jComboBoxProfesor.addItem(p);
        }
        refresh();
        jComboBoxPredmet.addItem(null);
        jComboBoxProfesor.addItem(null);
    }
    public void refresh(){
        ArrayList<Angazovanje> angazovanja = controller.Controller.getInstance().loadListAngazovanja();
        ModelTabeleAngazovanja mta = new ModelTabeleAngazovanja(angazovanja);
        jTableAngazovanje.setModel(mta);
    }
}
