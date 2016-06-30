/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author HASNA
 */
@Entity
public class AssistanteSociale implements Serializable{
    
     private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @OneToMany(mappedBy = "assistanteSociale1")
    private List<Dossier> dossiers;

    private String nom;
    private String prenom;
    private String tele;
    private String gmail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
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

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public AssistanteSociale() {
    }

    public AssistanteSociale(String id, List<Dossier> dossiers, String nom, String prenom, String tele, String gmail) {
        this.id = id;
        this.dossiers = dossiers;
        this.nom = nom;
        this.prenom = prenom;
        this.tele = tele;
        this.gmail = gmail;
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
        final AssistanteSociale other = (AssistanteSociale) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nom + " "+ prenom +"";
    }
    
    
    
    
    
    
    
    
    
}
