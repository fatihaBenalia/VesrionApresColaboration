/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author HASNA
 */
public class RendezVous {
    private int id;
    private String Nom;
    private int age;
    private Date datePriseRDV;
    private Date dateRDV;
    private String heureRDV;
    private String typeVisite;

    public RendezVous() {
    }

    public RendezVous(int id, String Nom, int age, Date datePriseRDV, Date dateRDV, String heureRDV, String typeVisite) {
        this.id = id;
        this.Nom = Nom;
        this.age = age;
        this.datePriseRDV = datePriseRDV;
        this.dateRDV = dateRDV;
        this.heureRDV = heureRDV;
        this.typeVisite = typeVisite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDatePriseRDV() {
        return datePriseRDV;
    }

    public void setDatePriseRDV(Date datePriseRDV) {
        this.datePriseRDV = datePriseRDV;
    }

    public Date getDateRDV() {
        return dateRDV;
    }

    public void setDateRDV(Date dateRDV) {
        this.dateRDV = dateRDV;
    }

    public String getHeureRDV() {
        return heureRDV;
    }

    public void setHeureRDV(String heureRDV) {
        this.heureRDV = heureRDV;
    }

    public String getTypeVisite() {
        return typeVisite;
    }

    public void setTypeVisite(String typeVisite) {
        this.typeVisite = typeVisite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }

    @Override
    public String toString() {
        return "RendezVous{" + "id=" + id + ", Nom=" + Nom + ", age=" + age + ", datePriseRDV=" + datePriseRDV + ", dateRDV=" + dateRDV + ", heureRDV=" + heureRDV + ", typeVisite=" + typeVisite + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RendezVous other = (RendezVous) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    

    

    
    
    
}
