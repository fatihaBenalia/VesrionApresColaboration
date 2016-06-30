/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;


import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Mere extends Personne {
    @OneToOne(mappedBy = "mere")
    private EtatSanteMere etatSanteMere;
    @OneToOne(mappedBy = "mere")
    private EtatEthique etatEthique;
    @OneToOne(mappedBy = "mere")
    private Dossier dossier;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeces;
    private String raisonDeces;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;

    public EtatEthique getEtatEthique() {
        return etatEthique;
    }

    public void setEtatEthique(EtatEthique etatEthique) {
        this.etatEthique = etatEthique;
    }

    public EtatSanteMere getEtatSanteMere() {
        return etatSanteMere;
    }

    public void setEtatSanteMere(EtatSanteMere etatSanteMere) {
        this.etatSanteMere = etatSanteMere;
    }

    
    
     
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    public String getRaisonDeces() {
        return raisonDeces;
    }

    public void setRaisonDeces(String raisonDeces) {
        this.raisonDeces = raisonDeces;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.dossier);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mere other = (Mere) obj;
        if (!Objects.equals(this.dossier, other.dossier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Mere{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }

    
    
}
