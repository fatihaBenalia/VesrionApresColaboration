/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Temporal;

/**
 *
 * @author samia
 */
@Entity
public class RemplirCaisseParrain implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRemplissage;
    
    @ManyToOne
    private Parrain parrain;
    @OneToMany(mappedBy = "remplirCaisseParrain")
    private List<RemplissageItem> remplissageItems;

    public Date getDateRemplissage() {
        return dateRemplissage;
    }

    public void setDateRemplissage(Date dateRemplissage) {
        this.dateRemplissage = dateRemplissage;
    }

    
    
    

    public Parrain getParrain() {
        return parrain;
    }

    public void setParrain(Parrain parrain) {
        this.parrain = parrain;
    }

    public List<RemplissageItem> getRemplissageItems() {
        return remplissageItems;
    }

    public void setRemplissageItems(List<RemplissageItem> remplissageItems) {
        this.remplissageItems = remplissageItems;
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
        if (!(object instanceof RemplirCaisseParrain)) {
            return false;
        }
        RemplirCaisseParrain other = (RemplirCaisseParrain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.RemplirCaisseParrain[ id=" + id + " ]";
    }
    
}
