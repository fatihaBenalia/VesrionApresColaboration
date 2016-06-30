/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Dossier implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDossier;

    private String numDossier;
    private String numero;
    private String nomFamille;
    private String adresseActuelle;
    private String remarque;
    private String proposition;
    private double montantTotal;
    private float indice;
    private int nbrMembre;
    private int nbrOrphelin;
    private int etat;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDernierPunition;
    
    @OneToMany(mappedBy = "dossier")
    private List<EtatPedagogiqueItem> etatPedagogiqueItems;
    @OneToMany(mappedBy = "dossier")
    private List<Membre> membres;
    @OneToMany(mappedBy = "dossier")
    private List<Orphelin> orphelins;
    @OneToMany(mappedBy = "dossier")
    private List<Virement> virements;
    @OneToMany(mappedBy = "dossier")
    private List<Parrinage> parrinages;

    @OneToMany(mappedBy = "dossier")
    private List<Materiel> materiels;

    @OneToMany(mappedBy = "dossier")
    private List<EtatSanteOrphelin> etatSanteOrphelins;

    @OneToMany(mappedBy = "dossier")
    private List<Punition> punitions;
    @OneToMany(mappedBy = "dossier")
    private List<HeritageItem> heritageItems;
    @OneToOne
    private Ramed ramed;
    @OneToOne
    private Mere mere;
    @OneToOne
    private Pere pere;
    @OneToOne
    private ResponsableFamille responsableFamille;
    @ManyToOne
    private ResponsableRegion responsableRegion;
    @ManyToOne
    private Region region;
    @OneToOne
    private EtatSanteMere etatSanteMere;
    @OneToOne
    private EtatEthique etatEthique;

    @OneToOne
    private Logement logement;
    @OneToOne
    private Activite activite;
    @OneToOne
    private Aide aide;
    @ManyToOne
    private AssistanteSociale assistanteSociale1;
    @ManyToOne
    private AssistanteSociale assistanteSociale2;
    
    private int annee;
    

    public Dossier() {
    }

    public Date getDateDernierPunition() {
        return dateDernierPunition;
    }

    public void setDateDernierPunition(Date dateDernierPunition) {
        this.dateDernierPunition = dateDernierPunition;
    }

    
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    
    public List<Punition> getPunitions() {
        return punitions;
    }

    public void setPunitions(List<Punition> punitions) {
        this.punitions = punitions;
    }

    
    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public List<HeritageItem> getHeritageItems() {
        return heritageItems;
    }

    public void setHeritageItems(List<HeritageItem> heritageItems) {
        this.heritageItems = heritageItems;
    }

    public Ramed getRamed() {
        return ramed;
    }

    public void setRamed(Ramed ramed) {
        this.ramed = ramed;
    }

    public ResponsableRegion getResponsableRegion() {
        return responsableRegion;
    }

    public void setResponsableRegion(ResponsableRegion responsableRegion) {
        this.responsableRegion = responsableRegion;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<EtatSanteOrphelin> getEtatSanteOrphelins() {
        return etatSanteOrphelins;
    }

    public void setEtatSanteOrphelins(List<EtatSanteOrphelin> etatSanteOrphelins) {
        this.etatSanteOrphelins = etatSanteOrphelins;
    }

    public EtatSanteMere getEtatSanteMere() {
        return etatSanteMere;
    }

    public void setEtatSanteMere(EtatSanteMere etatSanteMere) {
        this.etatSanteMere = etatSanteMere;
    }

    public List<EtatPedagogiqueItem> getEtatPedagogiqueItems() {
        return etatPedagogiqueItems;
    }

    public void setEtatPedagogiqueItems(List<EtatPedagogiqueItem> etatPedagogiqueItems) {
        this.etatPedagogiqueItems = etatPedagogiqueItems;
    }

    public List<Parrinage> getParrinages() {
        if(parrinages==null){
            parrinages=new ArrayList<>();
        }
        return parrinages;
    }

    public void setParrinages(List<Parrinage> parrinages) {
        this.parrinages = parrinages;
    }

    public int getNbrOrphelin() {
        return nbrOrphelin;
    }

    public void setNbrOrphelin(int nbrOrphelin) {
        this.nbrOrphelin = nbrOrphelin;
    }

    public int getNbrMembre() {
        return nbrMembre;
    }

    public void setNbrMembre(int nbrMembre) {
        this.nbrMembre = nbrMembre;
    }

    public float getIndice() {
        return indice;
    }

    public void setIndice(float indice) {
        this.indice = indice;
    }

    public List<Virement> getVirements() {
        return virements;
    }

    public void setVirements(List<Virement> virements) {
        this.virements = virements;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDossier() {
        return dateDossier;
    }

    public void setDateDossier(Date dateDossier) {
        this.dateDossier = dateDossier;
    }

    public Mere getMere() {
        if (mere == null) {
            mere = new Mere();
        }
        return mere;
    }

    public void setMere(Mere mere) {
        this.mere = mere;
    }

    public Pere getPere() {
        if (pere == null) {
            pere = new Pere();
        }
        return pere;
    }

    public void setPere(Pere pere) {
        this.pere = pere;
    }

    public ResponsableFamille getResponsableFamille() {
        if (responsableFamille == null) {
            responsableFamille = new ResponsableFamille();
        }
        return responsableFamille;
    }

    public void setResponsableFamille(ResponsableFamille responsableFamille) {
        this.responsableFamille = responsableFamille;
    }

    public String getNumDossier() {
        return numDossier;
    }

    public void setNumDossier(String numDossier) {
        this.numDossier = numDossier;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public String getAdresseActuelle() {
        return adresseActuelle;
    }

    public void setAdresseActuelle(String adresseActuelle) {
        this.adresseActuelle = adresseActuelle;
    }

    public List<Membre> getMembres() {
        if (membres == null) {
            membres = new ArrayList();
        }
        return membres;
    }

    public void setMembres(List<Membre> membres) {
        this.membres = membres;
    }

    public List<Orphelin> getOrphelins() {
        if (orphelins == null) {
            orphelins = new ArrayList();
        }
        return orphelins;
    }

    public void setOrphelins(List<Orphelin> orphelins) {
        this.orphelins = orphelins;
    }

    public EtatEthique getEtatEthique() {
        if (etatEthique == null) {
            etatEthique = new EtatEthique();
        }
        return etatEthique;
    }

    public void setEtatEthique(EtatEthique etatEthique) {
        this.etatEthique = etatEthique;
    }

    public Logement getLogement() {
        if (logement == null) {
            logement = new Logement();
        }
        return logement;
    }

    public void setLogement(Logement logement) {
        this.logement = logement;
    }

    public List<Materiel> getMateriels() {
        if (materiels == null) {
            materiels = new ArrayList();
        }
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public Activite getActivite() {
        if (activite == null) {
            activite = new Activite();
        }
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Aide getAide() {
        if (aide == null) {
            aide = new Aide();
        }
        return aide;
    }

    public void setAide(Aide aide) {
        this.aide = aide;
    }

    public AssistanteSociale getAssistanteSociale1() {
        if (assistanteSociale1 == null) {
            assistanteSociale1 = new AssistanteSociale();
        }
        return assistanteSociale1;
    }

    public void setAssistanteSociale1(AssistanteSociale assistanteSociale1) {
        this.assistanteSociale1 = assistanteSociale1;
    }

    public AssistanteSociale getAssistanteSociale2() {
        if (assistanteSociale2 == null) {
            assistanteSociale2 = new AssistanteSociale();
        }

        return assistanteSociale2;
    }

    public void setAssistanteSociale2(AssistanteSociale assistanteSociale2) {
        this.assistanteSociale2 = assistanteSociale2;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getProposition() {
        return proposition;
    }

    public void setProposition(String proposition) {
        this.proposition = proposition;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Dossier other = (Dossier) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  numero =""  + numero +"";
    }

}
