/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme.student;

import forme.GlavnaForma;
import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import mod.ModStudent;
import model.Student;
import validator.Validator;
   
/**
 *
 * @author Win 10
 */
public class DodajStudentaForma extends javax.swing.JDialog {
   private Student stud;
   private GlavnaForma roditelj;
    /**
     * Creates new form DodajStudentaForma
     */
    public DodajStudentaForma(java.awt.Frame parent, boolean modal, Student s, GlavnaForma f) {
        super(parent, modal);
        initComponents();
        stud = s;
        roditelj = f;
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

        jTextFieldIme = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPrezime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldBrInd = new javax.swing.JTextField();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonZapamti = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Prezime");

        jLabel3.setText("Broj Indeksa");

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

        jLabel1.setText("Ime");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldIme)
                    .addComponent(jTextFieldPrezime)
                    .addComponent(jTextFieldBrInd, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonZapamti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonKreiraj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldBrInd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addComponent(jButtonKreiraj)
                .addGap(35, 35, 35)
                .addComponent(jButtonZapamti)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        createStudent();
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapamtiActionPerformed
        try{
                controller.Controller.getInstance().saveStudent(stud);
                JOptionPane.showMessageDialog(this, "Систем је запамтио студента", "Успех", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
                
                }catch(Exception exc){
                     JOptionPane.showMessageDialog(this, "Систем не може да запамти студента", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
                }
        
       roditelj.osveziStudentTabelu();
        
    }//GEN-LAST:event_jButtonZapamtiActionPerformed

    /**
     * @param args the command line arguments
     */
   

    public void pripremiFormu(ModStudent m){
        switch (m) {
            case detalji:
                jTextFieldBrInd.setEditable(false);
                jTextFieldIme.setEditable(false);
                jTextFieldPrezime.setEditable(false);
                jButtonKreiraj.setVisible(false);
                jButtonZapamti.setVisible(false);
                jTextFieldBrInd.setText(stud.getBrojindeksa() + "");
                jTextFieldPrezime.setText(stud.getPrezime());
                jTextFieldIme.setText(stud.getIme());
                
                break;
                
            case dodaj:
                jTextFieldBrInd.setEnabled(true);
                jTextFieldIme.setEnabled(true);
                jTextFieldPrezime.setEnabled(true);
                jButtonKreiraj.setVisible(true);
                jButtonZapamti.setVisible(true);
                break;
            default:
                throw new AssertionError();
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextFieldBrInd;
    private javax.swing.JTextField jTextFieldIme;
    private javax.swing.JTextField jTextFieldPrezime;
    // End of variables declaration//GEN-END:variables

    private void createStudent() {
        Student s;
        String ime = jTextFieldIme.getText().trim();
        String prezime = jTextFieldPrezime.getText().trim();
        String brojind = jTextFieldBrInd.getText();
                 if(Validator.validatorImena(ime) && Validator.validatorPrezimena(prezime)&& Validator.validatorBrojIndeksa(brojind)){
                    
                s = new Student(-1, ime, prezime, Integer.valueOf(brojind));
                stud = s;
                 
                 }else
                 s = null;
                 
                 
                if(s == null){
                    JOptionPane.showMessageDialog(null, "Систем не може да креира студента");
                    
                }else
                    JOptionPane.showMessageDialog(null, "Систем је успешно креирао студента");
    }

    
}
