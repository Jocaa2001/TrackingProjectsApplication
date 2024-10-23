/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.tableModel;

import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;
import model.Predmet;
import model.Student;

/**
 *
 * @author Win 10
 */
public class ModelTabelePredmet extends AbstractTableModel {
    List<Predmet> lista;
    String[] kolone = {"ID","ESPB","Naziv","Obavezan"};

    public ModelTabelePredmet(List<Predmet> lista) {
        this.lista = lista;
    }

    public List<Predmet> getLista() {
        return lista;
    }
    
    
    
    @Override
    public int getRowCount() {
       return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Predmet p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0: return p.getIdpredmet();
            case 1: return p.getEspb();
            case 2: return p.getNaziv();
            case 3: return p.isObavezan() ? "Da":"Ne";
            default:
                return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public void findPredmet(int espb, String naziv, boolean obavezan) {
         List<Predmet> filtriranaLista = lista.stream()
                .filter(predmet -> espb == 0 || predmet.getEspb() == espb)
                .filter(predmet -> naziv == null || naziv.isEmpty() || predmet.getNaziv().toLowerCase().contains(naziv.toLowerCase()))
                .filter(predmet -> predmet.isObavezan() == obavezan)
                .collect(Collectors.toList());
        this.lista = filtriranaLista;
        fireTableDataChanged();
        
    }
        
    public void pretraziNoBool(int espb, String naziv) {
         List<Predmet> filtriranaLista = lista.stream()
                .filter(predmet -> espb == 0 || predmet.getEspb() == espb)
                .filter(predmet -> naziv == null || naziv.isEmpty() || predmet.getNaziv().toLowerCase().contains(naziv.toLowerCase()))
                
                .collect(Collectors.toList());
        this.lista = filtriranaLista;
        fireTableDataChanged();
    }
    
    
    
}
