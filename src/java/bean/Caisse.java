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
public class Caisse implements Serializable {
    @OneToOne(mappedBy = "caisse")
    private RemplissageItemPhilantrope remplissageItemPhilantrope;
    @OneToOne(mappedBy = "caisse")
    private RemplissageItem remplissageItem;
  
    @OneToMany(mappedBy = "caisse")
    private List<OperationCaisse> operations;
 
    private static final long serialVersionUID = 1L;
  
    @Id
   private String id;
    private double montant;
    private int type; /// 1/ couverture 2/ habillement 3/sante 4/ scolarite 5/ aid

    public List<OperationCaisse> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationCaisse> operations) {
        this.operations = operations;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Caisse other = (Caisse) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
