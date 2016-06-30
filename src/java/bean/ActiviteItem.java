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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author User
 */
@Entity
public class ActiviteItem implements Serializable {
    @ManyToOne
    private Activite activite;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profession;
    private String weekend;
    private String recruteur;
    private int dureeTravail;
    private String capacite;
    @OneToOne
    private Membre membre;
    private double montantMonsuel;

    public ActiviteItem() {
    }

    public ActiviteItem(Activite activite, Long id, String profession, String weekend, String recruteur, int dureeTravail, String capacite, Membre membre, double montantMonsuel) {
        this.activite = activite;
        this.id = id;
        this.profession = profession;
        this.weekend = weekend;
        this.recruteur = recruteur;
        this.dureeTravail = dureeTravail;
        this.capacite = capacite;
        this.membre = membre;
        this.montantMonsuel = montantMonsuel;
    }

    
    
    public double getMontantMonsuel() {
        return montantMonsuel;
    }

    public void setMontantMonsuel(double montantMonsuel) {
        this.montantMonsuel = montantMonsuel;
    }

    
    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public int getDureeTravail() {
        return dureeTravail;
    }

    public void setDureeTravail(int dureeTravail) {
        this.dureeTravail = dureeTravail;
    }

    public String getCapacite() {
        return capacite;
    }

    public void setCapacite(String capacite) {
        this.capacite = capacite;
    }

    public Membre getMembre() {
        if(membre==null){
            membre= new Membre();
        }
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.id);
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
        final ActiviteItem other = (ActiviteItem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ActiviteItem{" + "membre=" + membre + ", montantMonsuel=" + montantMonsuel + '}';
    }
    
    
    
    
}
