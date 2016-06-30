/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.RendezVous;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author HASNA
 */
public class RDVhelper extends AbstractHelper<RendezVous> {
    
    
     private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{new AbstractHelperItem("RDV N°", "id"),
           new AbstractHelperItem("Nom_Patient", "nom"),
            new AbstractHelperItem("Age", "age"),
            new AbstractHelperItem("RDV_pour", "dateRDV"),
            new AbstractHelperItem("Pris_le", "datePriseRDV"),
            new AbstractHelperItem("Heure_Rdv", "heureRDV"),
            new AbstractHelperItem("Type", "typeVisite"),
        };
    }

    public RDVhelper(JTable jTable, List<RendezVous> list) {
        super(titres, jTable, list);
    }

    public RDVhelper(JTable jTable) {
        super(titres, jTable);

    }
    
    
    
}
