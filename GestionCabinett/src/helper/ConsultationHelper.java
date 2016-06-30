/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package helper;
//
//import bean.Consultation;
//import java.util.List;
//import javax.swing.JTable;
/**
 *
 * @author User
 */
//public class ConsultationHelper extends AbstractHelper<Consultation> {
//
//    private static AbstractHelperItem[] titres;
//
//    static {
//        titres = new AbstractHelperItem[]{new AbstractHelperItem("Id_Consultation", "id"),
//            new AbstractHelperItem("Nom et Prénom Patient", "patient"),
//            new AbstractHelperItem("Date de Consultation", "dateConsultation"),
//            new AbstractHelperItem("Montant Total", "MontantTotal"),
//            new AbstractHelperItem("Montant Payé", "MontantPayé"),
//            new AbstractHelperItem("Etat Paiement", "EtatPaiement"),
//        };
//    }
//
//    public ConsultationHelper(JTable jTable, List<Consultation> list) {
//        super(titres, jTable, list);
//    }
//
//    public ConsultationHelper(JTable jTable) {
//        super(titres, jTable);
//
//    }
//
//}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import bean.Consultation;
import bean.Patient;
import java.util.List;
import javax.swing.JTable;
import service.PatientService;
import util.DaoEngigne;

/**
 *
 * @author lenovo
 */
public class ConsultationHelper extends AbstractHelper<Consultation> {

    private static AbstractHelperItem[] titres;

    static {
        titres = new AbstractHelperItem[]{
            new AbstractHelperItem("N°Con", "id"),
            new AbstractHelperItem("Patient"),
            new AbstractHelperItem("Date_Con", "dateConsultation"),
            new AbstractHelperItem("Motif ", "Motifconsultation"),
             new AbstractHelperItem("Montant Total", "MontantTotal"),
            new AbstractHelperItem("Montant Payé", "MontantPayé"),
            new AbstractHelperItem("Etat_Paiement", "EtatPaiement"),
        };
        
    }

    public ConsultationHelper(JTable jTable, List<Consultation> list) {
        super(titres, jTable, list);
    }

    public ConsultationHelper(JTable jTable) {
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
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());

                    } else if (columnIndex == 2) {

                        return list.get(rowIndex).getDateConsultation();
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());

                    } else if (columnIndex == 3) {

                        return list.get(rowIndex).getMotifconsultation();
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());
 
                    } 
                    else if (columnIndex == 4) {

                        return list.get(rowIndex).getMontantTotal();
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());
 
                    } 
                    else if (columnIndex == 5) {

                        return list.get(rowIndex).getMontantPayé();
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());
 
                    } 
                    else if (columnIndex == 6) {

                        return list.get(rowIndex).getEtatPaiement();
                        //  System.out.println("o haa patient  ==> "+patient.getNomFamille());
 
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
