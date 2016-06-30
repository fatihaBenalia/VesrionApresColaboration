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
public class AideItem implements Serializable {
    @ManyToOne
    private Aide aide;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ressource;
    private String relation;
    private String type;
    private String quantite;
    private String duree;
    private double montantMensuelle;
    private String raisonAide;
    private String commentaire;

    public AideItem() {
    }

    public AideItem(Aide aide, Long id, String ressource, String relation, String type, String quantite, String duree, double montantMensuelle, String raisonAide, String commentaire) {
        this.aide = aide;
        this.id = id;
        this.ressource = ressource;
        this.relation = relation;
        this.type = type;
        this.quantite = quantite;
        this.duree = duree;
        this.montantMensuelle = montantMensuelle;
        this.raisonAide = raisonAide;
        this.commentaire = commentaire;
    }

    
    
    public Aide getAide() {
        return aide;
    }

    public void setAide(Aide aide) {
        this.aide = aide;
    }

    public String getRessource() {
        return ressource;
    }

    public void setRessource(String ressource) {
        this.ressource = ressource;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public double getMontantMensuelle() {
        return montantMensuelle;
    }

    public void setMontantMensuelle(double montantMensuelle) {
        this.montantMensuelle = montantMensuelle;
    }

    public String getRaisonAide() {
        return raisonAide;
    }

    public void setRaisonAide(String raisonAide) {
        this.raisonAide = raisonAide;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
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
        if (!(object instanceof AideItem)) {
            return false;
        }
        AideItem other = (AideItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.AideItem[ id=" + id + " ]";
    }
    
}
