/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author HASNA
 */
@Entity
public class EtatSanteMere implements Serializable {

    @OneToOne(mappedBy = "etatSanteMere")
    private Dossier dossier;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeHandicape;
    private int etatHandicape;
    private String maladie;
    private String suivieMaladieChronique;
    private String suivieHandicape;
    private String suivieMaladieRepetitif;
    private double depense;
    private String besoin;
    @OneToOne
    private Mere mere;

    public EtatSanteMere() {
    }

    public EtatSanteMere(Dossier dossier, Long id, String typeHandicape, int etatHandicape, String maladie, String suivieMaladieChronique, String suivieHandicape, String suivieMaladieRepetitif, double depense, String besoin, Mere mere) {
        this.dossier = dossier;
        this.id = id;
        this.typeHandicape = typeHandicape;
        this.etatHandicape = etatHandicape;
        this.maladie = maladie;
        this.suivieMaladieChronique = suivieMaladieChronique;
        this.suivieHandicape = suivieHandicape;
        this.suivieMaladieRepetitif = suivieMaladieRepetitif;
        this.depense = depense;
        this.besoin = besoin;
        this.mere = mere;
    }


    
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public String getTypeHandicape() {
        return typeHandicape;
    }

    public void setTypeHandicape(String typeHandicape) {
        this.typeHandicape = typeHandicape;
    }

    public int getEtatHandicape() {
        return etatHandicape;
    }

    public void setEtatHandicape(int etatHandicape) {
        this.etatHandicape = etatHandicape;
    }

    public String getMaladie() {
        return maladie;
    }

    public void setMaladie(String maladie) {
        this.maladie = maladie;
    }

    public String getSuivieMaladieChronique() {
        return suivieMaladieChronique;
    }

    public void setSuivieMaladieChronique(String suivieMaladieChronique) {
        this.suivieMaladieChronique = suivieMaladieChronique;
    }

    public String getSuivieHandicape() {
        return suivieHandicape;
    }

    public void setSuivieHandicape(String suivieHandicape) {
        this.suivieHandicape = suivieHandicape;
    }

    public String getSuivieMaladieRepetitif() {
        return suivieMaladieRepetitif;
    }

    public void setSuivieMaladieRepetitif(String suivieMaladieRepetitif) {
        this.suivieMaladieRepetitif = suivieMaladieRepetitif;
    }

    public double getDepense() {
        return depense;
    }

    public void setDepense(double depense) {
        this.depense = depense;
    }

    public String getBesoin() {
        return besoin;
    }

    public void setBesoin(String besoin) {
        this.besoin = besoin;
    }

    public Mere getMere() {
        return mere;
    }

    public void setMere(Mere mere) {
        this.mere = mere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtatSanteMere)) {
            return false;
        }
        EtatSanteMere other = (EtatSanteMere) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.EtatSanteMere[ id=" + id + " ]";
    }

}
