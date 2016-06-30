/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import javax.persistence.Entity;

import javax.persistence.OneToOne;

/**
 *
 * @author HASNA
 */
@Entity
public class Mediataire extends Personne {
    @OneToOne(mappedBy = "mediataire")
    private Parrain parrain;

    public Parrain getParrain() {
        return parrain;
    }

    public void setParrain(Parrain parrain) {
        this.parrain = parrain;
    }
  
    @Override
    public String toString() {
        return   nom + " " +prenom+ " ";
    }
    
}
