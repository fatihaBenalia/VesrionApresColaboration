/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;


import bean.Patient;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author User
 */
public class PatientHelper extends AbstractHelper<Patient> {
    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{new AbstractHelperItem("N°Dossier", "id"),
           new AbstractHelperItem("Nom", "nom"),
            new AbstractHelperItem("Prénom", "prenom"),
            new AbstractHelperItem("Date_Naissance", "dateNaissance"),
            new AbstractHelperItem("N°Fixe", "Telfix"),
            new AbstractHelperItem("N°Mobile", "telMobile"),
            new AbstractHelperItem("Ville", "ville"),
        };
    }

    public PatientHelper(JTable jTable, List<Patient> list) {
        super(titres, jTable, list);
    }

    public PatientHelper(JTable jTable) {
        super(titres, jTable);

    }
    
    
    
    
}
