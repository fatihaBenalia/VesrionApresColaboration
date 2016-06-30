/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author HASNA
 */
public class Caisse {
    private String id;
    
    public List<Consultation> consultations;
    public Double montant;
    public Double reste;
    public String paiement;

    public Caisse() {
    }

    public Caisse(String id, List<Consultation> consultations, Double montant, Double reste, String paiement) {
        this.id = id;
        this.consultations = consultations;
        this.montant = montant;
        this.reste = reste;
        this.paiement = paiement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<Consultation> consultations) {
        this.consultations = consultations;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getReste() {
        return reste;
    }

    public void setReste(Double reste) {
        this.reste = reste;
    }

    public String getPaiement() {
        return paiement;
    }

    public void setPaiement(String paiement) {
        this.paiement = paiement;
    }

    @Override
    public String toString() {
        return "Caisse{" + "id=" + id + ", montant=" + montant + ", reste=" + reste + ", paiement=" + paiement + '}';
    }

    

  
    
}
