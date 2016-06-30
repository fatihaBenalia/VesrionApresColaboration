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
import javax.persistence.OneToOne;

/**
 *
 * @author HASNA
 */
@Entity
public class ResponsableRegion implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String gmail;
    private String tele;
    @OneToOne
    private Region region;
    
    @OneToMany(mappedBy = "responsableRegion")
    private List<SousResponsableRegion> sousResponsableRegions;
    
    
    @OneToMany(mappedBy = "responsableRegion")
    private List<Dossier> dossiers;

    public ResponsableRegion() {
    }

    
    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<SousResponsableRegion> getSousResponsableRegions() {
        return sousResponsableRegions;
    }

    public void setSousResponsableRegions(List<SousResponsableRegion> sousResponsableRegions) {
        this.sousResponsableRegions = sousResponsableRegions;
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

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    
    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final ResponsableRegion other = (ResponsableRegion) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  nom + " " + prenom+ " " +region;
    }
    
    
    

}
