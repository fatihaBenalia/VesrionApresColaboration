/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author HASNA
 */
@Entity
public class HeritageItem implements Serializable {
    @ManyToOne
    private Dossier dossier;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeHeritage;
    private String type;
    private String typePossession;
    private String methodeUtilisation;
    private Double montant;
    private String blemsApresDeces;
    private String resultatsDecision;

    public HeritageItem() {
    }

    public Dossier getDossier() {
        return dossier;
    }

    public void setDossier(Dossier dossier) {
        this.dossier = dossier;
    }
 
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTypeHeritage() {
        return typeHeritage;
    }

    public void setTypeHeritage(String typeHeritage) {
        this.typeHeritage = typeHeritage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypePossession() {
        return typePossession;
    }

    public void setTypePossession(String typePossession) {
        this.typePossession = typePossession;
    }

    public String getMethodeUtilisation() {
        return methodeUtilisation;
    }

    public void setMethodeUtilisation(String methodeUtilisation) {
        this.methodeUtilisation = methodeUtilisation;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getBlemsApresDeces() {
        return blemsApresDeces;
    }

    public void setBlemsApresDeces(String blemsApresDeces) {
        this.blemsApresDeces = blemsApresDeces;
    }

    public String getResultatsDecision() {
        return resultatsDecision;
    }

    public void setResultatsDecision(String resultatsDecision) {
        this.resultatsDecision = resultatsDecision;
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
        if (!(object instanceof HeritageItem)) {
            return false;
        }
        HeritageItem other = (HeritageItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.HeritageItem[ id=" + id + " ]";
    }
    
}
