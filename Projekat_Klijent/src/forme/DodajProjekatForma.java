/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import forme.tableModel.ModelTabeleProjekti;
import forme.tableModel.ModelTabeleStudent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import mod.ModProjekat;
import model.Angazovanje;
import model.Predmet;
import model.Profesor;
import model.Projekat;
import model.Student;

/**
 *
 * @author Win 10
 */
public class DodajProjekatForma extends javax.swing.JDialog {
    private GlavnaForma gf;
    private ArrayList <Student> s = new ArrayList<>();
    private ArrayList <Projekat> projekti;
    private Predmet pred;
    private Profesor prof;
    private Projekat p;
    private ModProjekat mp;
    
    /**
     * Creates new form DodajProjekatForma
     */
    public DodajProjekatForma(java.awt.Frame parent, boolean modal, GlavnaForma g, ArrayList<Student> s, Predmet pred,Profesor prof, ModProjekat mp) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.s = s;
        this.prof = prof;
        this.pred = pred;
        this.gf = g;
        this.mp = mp;
        populateComboBoxes();
        pripremiFormu();
        
    }

    public DodajProjekatForma(java.awt.Frame parent, boolean modal,ArrayList<Projekat> projekti,ModProjekat mp) {
        super(parent, modal);
        initComponents();
        this.projekti = projekti;
        this.mp = mp;
        populateComboBoxes();
        pripremiFormuIzmena();
        
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
        jComboBoxPredmet = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxProfesor = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldBrojPoena = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldRokPredaje = new javax.swing.JTextField();
        jButtonZapamti = new javax.swing.JButton();
        jButtonKreiraj = new javax.swing.JButton();
        jButtonIzmeni = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAngazovaniStudenti = new javax.swing.JTable();
        jButtonDodaj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableStudenti = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Predmet");

        jLabel3.setText("Profesor");

        jLabel4.setText("Tema");

        jLabel5.setText("Broj Poena");

        jLabel6.setText("Rok Predaje (YYYY.MM.DD)");

        jButtonZapamti.setText("Zapamti");
        jButtonZapamti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZapamtiActionPerformed(evt);
            }
        });

        jButtonKreiraj.setText("Kreiraj");
        jButtonKreiraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKreirajActionPerformed(evt);
            }
        });

        jButtonIzmeni.setText("Izmeni");
        jButtonIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzmeniActionPerformed(evt);
            }
        });

        jLabel7.setText("Studenti");

        jLabel2.setText("Angazovani studenti");

        jTableAngazovaniStudenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableAngazovaniStudenti);

        jButtonDodaj.setText("dodaj");
        jButtonDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDodajActionPerformed(evt);
            }
        });

        jButtonObrisi.setText("obrisi");
        jButtonObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonObrisiActionPerformed(evt);
            }
        });

        jTableStudenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStudenti);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldRokPredaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(jTextFieldBrojPoena, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(jTextFieldTema, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jComboBoxProfesor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButtonZapamti)
                        .addGap(32, 32, 32)
                        .addComponent(jButtonKreiraj, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jButtonIzmeni))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(405, 405, 405)
                        .addComponent(jButtonDodaj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonObrisi))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxPredmet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextFieldBrojPoena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldRokPredaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonZapamti)
                    .addComponent(jButtonKreiraj)
                    .addComponent(jButtonIzmeni))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonKreirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKreirajActionPerformed
        Profesor prof = (Profesor) jComboBoxProfesor.getSelectedItem();
        
        Predmet pred = (Predmet) jComboBoxPredmet.getSelectedItem();
        String tema = jTextFieldTema.getText();
        String brojPoena = jTextFieldBrojPoena.getText();
        String datum = jTextFieldRokPredaje.getText();
        
        if(!(validator.Validator.validatorIntegerTextBoxa(brojPoena)) || !(validator.Validator.validatorDatuma(datum)) || !(validator.Validator.validatorImena(tema))){
            
            JOptionPane.showMessageDialog(this, "Систем не може да креира пројекат");
            return;
        }
        if(!(proveriDaLiJeAngazovan(prof,pred))){
             JOptionPane.showMessageDialog(this, "Професор није ангажован на том предмету");
             return;
        }
        int brp = Integer.valueOf(brojPoena);
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
       
         
        try {
            java.util.Date utilDate = sdf.parse(datum);
            p = new Projekat(-1, s, s.get(0), pred, prof, tema, brp, utilDate);
            JOptionPane.showMessageDialog(this, "Систем је креирао пројекат");
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Систем не може да креира пројекат.");
            Logger.getLogger(DodajProjekatForma.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    }//GEN-LAST:event_jButtonKreirajActionPerformed

    private void jButtonZapamtiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZapamtiActionPerformed
        try {

            
            controller.Controller.getInstance().saveProjekat(p);
            
            //refreshovanje tabele
            ArrayList<Projekat> projekti = (ArrayList<Projekat>) controller.Controller.getInstance().loadListProjekti();
            ModelTabeleProjekti mtp = new ModelTabeleProjekti(projekti);
            gf.getjTableProjekti().setModel(mtp);
             JOptionPane.showMessageDialog(this, "Систем је запамтио пројекат", "Успех", JOptionPane.INFORMATION_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(DodajProjekatForma.class.getName()).log(Level.SEVERE, null, ex);
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Систем не може да запамти пројекат", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonZapamtiActionPerformed

    private void jButtonIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzmeniActionPerformed
      try{
        Profesor prof = (Profesor) jComboBoxProfesor.getSelectedItem();
        Predmet pred = (Predmet) jComboBoxPredmet.getSelectedItem();
        String tema = jTextFieldTema.getText();
        
        String brojPoena = jTextFieldBrojPoena.getText();
        int poeni = Integer.parseInt(brojPoena);
        
        String datum = jTextFieldRokPredaje.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        Date d = null;
        
        if(!(validator.Validator.validatorIntegerTextBoxa(brojPoena)) || !(validator.Validator.validatorDatuma(datum)) || !(validator.Validator.validatorImena(tema))){
            
            JOptionPane.showMessageDialog(this, "Систем не може да креира пројекат");
            return;
        }
        if(!(proveriDaLiJeAngazovan(prof,pred))){
             JOptionPane.showMessageDialog(this, "Професор није ангажован на том предмету");
             return;
        }
        
         try {
            d = sdf.parse(datum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ModelTabeleStudent mts = (ModelTabeleStudent) jTableAngazovaniStudenti.getModel();
        
        
        ArrayList<Student> studenti = (ArrayList<Student>) mts.getLista();
        Projekat p = new Projekat(pred, prof, tema,poeni , d, studenti, projekti.get(0).getId());
        
        controller.Controller.getInstance().izmeniProjekat(p);
         JOptionPane.showMessageDialog(this, "Систем је запамтио пројекат", "Успех", JOptionPane.INFORMATION_MESSAGE);
      } catch(Exception e){
          e.printStackTrace();
          JOptionPane.showMessageDialog(this, "Систем не може да запамти пројекат", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
      }
        
        //refreshovanje tabele
//        ArrayList<Projekat> projekti = (ArrayList<Projekat>) controller.Controller.getInstance().loadListProjekti();
//            ModelTabeleProjekti mtp = new ModelTabeleProjekti(projekti);
//            gf.getjTableProjekti().setModel(mtp);
        //this.dispose();
    }//GEN-LAST:event_jButtonIzmeniActionPerformed

    private void jButtonDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDodajActionPerformed
       int selektovaniRed = jTableStudenti.getSelectedRow();
       if(selektovaniRed == -1){
            JOptionPane.showMessageDialog(this, "Нисте изабрали ниједног студента", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
            return;
       }
       ModelTabeleStudent mts = (ModelTabeleStudent) jTableStudenti.getModel();
       Student stud = mts.getLista().get(selektovaniRed);
       
        ModelTabeleStudent angazovani = (ModelTabeleStudent) jTableAngazovaniStudenti.getModel();
       
       angazovani.getLista().add(stud);
       angazovani.fireTableDataChanged();
    }//GEN-LAST:event_jButtonDodajActionPerformed

    private void jButtonObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonObrisiActionPerformed
       int selektovaniRed = jTableAngazovaniStudenti.getSelectedRow();
       if(selektovaniRed == -1){
            JOptionPane.showMessageDialog(this, "Нисте изабрали ниједног студента", "Неуспех", JOptionPane.INFORMATION_MESSAGE);
            return;
       }
       
       ModelTabeleStudent mts = (ModelTabeleStudent) jTableAngazovaniStudenti.getModel();
       mts.getLista().remove(selektovaniRed);
       mts.fireTableDataChanged();
    }//GEN-LAST:event_jButtonObrisiActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzmeni;
    private javax.swing.JButton jButtonKreiraj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonZapamti;
    private javax.swing.JComboBox<Predmet> jComboBoxPredmet;
    private javax.swing.JComboBox<Profesor> jComboBoxProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAngazovaniStudenti;
    private javax.swing.JTable jTableStudenti;
    private javax.swing.JTextField jTextFieldBrojPoena;
    private javax.swing.JTextField jTextFieldRokPredaje;
    private javax.swing.JTextField jTextFieldTema;
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
       
        List<Student> studenti = controller.Controller.getInstance().loadListStudenti();
        jTableStudenti.setModel(new ModelTabeleStudent(studenti));
    }

    private boolean proveriDaLiJeAngazovan(Profesor prof, Predmet pred) {
        List<Angazovanje> angazovanja = controller.Controller.getInstance().loadListAngazovanja();
        for (Angazovanje a : angazovanja) {
            if(a.getProfesor().equals(prof)&&a.getPredmet().equals(pred)){
                return true;
            }
        }
        return false;
    }

    private void pripremiFormu() {
        
        jComboBoxPredmet.setSelectedItem(pred);
        jComboBoxProfesor.setSelectedItem(prof);
        jTableStudenti.setModel(new ModelTabeleStudent(s));
        if(mp.equals(ModProjekat.dodaj)){
            jButtonIzmeni.setVisible(false);
            jButtonDodaj.setVisible(false);
            jButtonObrisi.setVisible(false);
        }
        jTableStudenti.setEnabled(false);
        jTableStudenti.setVisible(false);
        ModelTabeleStudent mts = new ModelTabeleStudent(s);
        jTableAngazovaniStudenti.setModel(mts);
       jLabel7.setVisible(false);
       jPanel1.setVisible(false);
        remove(jTableStudenti);
        this.revalidate();
        this.repaint();
        
    }

    private void pripremiFormuIzmena() {
         JOptionPane.showMessageDialog(this, "Систем је учитао пројекат", "Успех", JOptionPane.INFORMATION_MESSAGE);
         setLocationRelativeTo(null);
        jComboBoxPredmet.setEnabled(true);
        jComboBoxPredmet.setSelectedItem(projekti.get(0).getPredmet());
        jComboBoxProfesor.setSelectedItem(projekti.get(0).getProfesor());
        jTextFieldTema.setText(projekti.get(0).getTema());
        jTextFieldBrojPoena.setText(projekti.get(0).getBrojpoena() + "");
        jButtonKreiraj.setVisible(false);
        jButtonZapamti.setVisible(false);
        for (Projekat projekat : projekti) {
            s.add(projekat.getStudent());
        }
        ModelTabeleStudent mts = new ModelTabeleStudent(s);
        jTableAngazovaniStudenti.setModel(mts);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String formattedDate = sdf.format(projekti.get(0).getRokPredaje());
        jTextFieldRokPredaje.setText(formattedDate);
    }
}
