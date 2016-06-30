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
 * @author User
 */
@Entity
public class Region implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomRegion;
    @OneToOne (mappedBy = "region")
    private ResponsableRegion responsableRegion;
    @OneToMany(mappedBy = "region")
    private List<SousRegion> sousRegions;
    
    @OneToMany(mappedBy = "region")
    private List<Dossier> dossiers;
    
    
    
    

    public Region() {
    }

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    
    public List<SousRegion> getSousRegions() {
        return sousRegions;
    }

    public void setSousRegions(List<SousRegion> sousRegions) {
        this.sousRegions = sousRegions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public ResponsableRegion getResponsableRegion() {
        return responsableRegion;
    }

    public void setResponsableRegion(ResponsableRegion responsableRegion) {
        this.responsableRegion = responsableRegion;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Region other = (Region) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return   nomRegion +"" ;
    }
    
    
    
    

}
