/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.List;
import javax.swing.JTable;
import service.PatientService;
import bean.Ordonnance;
/**
 *
 * @author User
 */
public class OrdonnanceHelper extends AbstractHelper<Ordonnance> {
    
    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("N°Con", "id"),
            new AbstractHelperItem("Patient"),
            new AbstractHelperItem("Nom_medecin", "nomMedecin"),
            new AbstractHelperItem("Texte Ordonnace ", "textOrdo"),
         
        };
        
    }

    public OrdonnanceHelper(JTable jTable, List<Ordonnance> list) {
        super(titres, jTable, list);
    }

    public OrdonnanceHelper(JTable jTable) {
        super(titres, jTable);

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PatientService patientService = new PatientService();
        try {
            if (list != null && rowIndex < list.size()) {
                for (int i = 0; i < abstractHelperItem.length; i++) {
                    if (columnIndex == 1) {

                        list.get(rowIndex).setPatient(patientService.findById(list.get(rowIndex).getPatient().getId()));
                        return list.get(rowIndex).getPatient().getNom();
                        

                    } else if (columnIndex == 2) {

                        return list.get(rowIndex).getNomMedecin();
                        

                    } 
                   
                    else if (columnIndex == 3) {

                        return list.get(rowIndex).getTextOrdo();
                        

                    } 
                    
                    else if (columnIndex == 4) {

                        return list.get(rowIndex).getId();
                        

                    } 
                    
                    
                    
                    
                    else {
                        return super.getValueAt(rowIndex);
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
