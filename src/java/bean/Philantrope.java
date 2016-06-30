/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.util.List;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

/**
 *
 * @author HASNA
 */
@Entity
public class Philantrope extends Personne {
    @OneToMany(mappedBy = "philantrope")
    private List<RemplirCaissePhilantrope> remplirCaissePhilantropes;
    private static final long serialVersionUID = 1L;
   private double montant;

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public List<RemplirCaissePhilantrope> getRemplirCaissePhilantropes() {
        return remplirCaissePhilantropes;
    }

    public void setRemplirCaissePhilantropes(List<RemplirCaissePhilantrope> remplirCaissePhilantropes) {
        this.remplirCaissePhilantropes = remplirCaissePhilantropes;
    }

    @Override
    public String toString() {
        return "Philantrope{" + "remplirCaissePhilantropes=" + remplirCaissePhilantropes + ", montant=" + montant + '}';
    }
   
    
   
}
