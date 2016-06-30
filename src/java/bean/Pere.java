/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Pere extends Personne {
    @OneToOne(mappedBy = "pere")
    private Dossier dossier;

    private String travailavantDeces;
    private String recruteur;
    private int cnss;
    private String numCnss;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeces;
    private String raisonDeces;
    private String nomAvocat;
    private String cinAvocat;
    private String teleAvocat;

    public String getNomAvocat() {
        return nomAvocat;
    }

    public void setNomAvocat(String nomAvocat) {
        this.nomAvocat = nomAvocat;
    }

    public String getCinAvocat() {
        return cinAvocat;
    }

    public void setCinAvocat(String cinAvocat) {
        this.cinAvocat = cinAvocat;
    }

    public String getTeleAvocat() {
        return teleAvocat;
    }

    public void setTeleAvocat(String teleAvocat) {
        this.teleAvocat = teleAvocat;
    }
    

    
    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }

    public String getTravailavantDeces() {
        return travailavantDeces;
    }

    public void setTravailavantDeces(String travailavantDeces) {
        this.travailavantDeces = travailavantDeces;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public int getCnss() {
        return cnss;
    }

    public void setCnss(int cnss) {
        this.cnss = cnss;
    }

    public String getNumCnss() {
        return numCnss;
    }

    public void setNumCnss(String numCnss) {
        this.numCnss = numCnss;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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
    
    @Override
    public String toString() {
        return  " pere : nom=" + nom + ",prenom=" + prenom + '}';
    }
    
    
}
