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
public class RemplirCaissePhilantrope implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRemplissage;
    
    @ManyToOne
    private Philantrope philantrope;
    @OneToMany(mappedBy = "remplirCaissePhilantrope")
    private List<RemplissageItemPhilantrope> remplissageItemPhilantrope;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateRemplissage() {
        return dateRemplissage;
    }

    public void setDateRemplissage(Date dateRemplissage) {
        this.dateRemplissage = dateRemplissage;
    }

   

    public Philantrope getPhilantrope() {
        return philantrope;
    }

    public void setPhilantrope(Philantrope philantrope) {
        this.philantrope = philantrope;
    }

    public List<RemplissageItemPhilantrope> getRemplissageItemPhilantrope() {
        return remplissageItemPhilantrope;
    }

    public void setRemplissageItemPhilantrope(List<RemplissageItemPhilantrope> remplissageItemPhilantrope) {
        this.remplissageItemPhilantrope = remplissageItemPhilantrope;
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
        if (!(object instanceof RemplirCaissePhilantrope)) {
            return false;
        }
        RemplirCaissePhilantrope other = (RemplirCaissePhilantrope) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.RemplirCaissePhilantrope[ id=" + id + " ]";
    }
    
}
