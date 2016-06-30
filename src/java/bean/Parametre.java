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


/**
 *
 * @author ASUS
 */
@Entity
public class Parametre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valeur1;//600
    private double valeur2;//300
    private double valeur3;//300
    private double valeur4;//50

    public Parametre() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValeur1() {
        return valeur1;
    }

    public void setValeur1(double valeur1) {
        this.valeur1 = valeur1;
    }

    public double getValeur2() {
        return valeur2;
    }

    public void setValeur2(double valeur2) {
        this.valeur2 = valeur2;
    }

    public double getValeur3() {
        return valeur3;
    }

    public void setValeur3(double valeur3) {
        this.valeur3 = valeur3;
    }

    public double getValeur4() {
        return valeur4;
    }

    public void setValeur4(double valeur4) {
        this.valeur4 = valeur4;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Parametre other = (Parametre) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Parametre{" + "id=" + id + '}';
    }
   
    
    
    
    
    

    

}
