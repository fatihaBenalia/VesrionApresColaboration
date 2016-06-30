/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;

/**
 *
 * @author samia
 */
@Entity
public class Parrain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @OneToOne
    private Mediataire mediataire;
    private String nom;
    private String prenom;
    private String telephone;
    private String gmail;
    private String adresse;

    @OneToOne
    private Parrinage parrinage;

    public Parrain() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public Parrinage getParrinage() {
        return parrinage;
    }

    public void setParrinage(Parrinage parrinage) {
        this.parrinage = parrinage;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Mediataire getMediataire() {
        if (mediataire == null) {
            mediataire = new Mediataire();
        }
        return mediataire;
    }

    public void setMediataire(Mediataire mediataire) {
        this.mediataire = mediataire;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Parrain other = (Parrain) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

   
    

    @Override
    public String toString() {
        return "nom=" + nom + "prenom=" + prenom;
    }

}
