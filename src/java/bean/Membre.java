/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author User
 */
@Entity
public class Membre implements Serializable {
    @OneToOne(mappedBy = "membre")
    private ActiviteItem activiteItem;
    @ManyToOne
    private Dossier dossier;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String relationOrphelin;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String profession;
    private String typeMetier;
    private String niveauScolaire;
    private String recruteur;
    private String ecole;
    private double salaire;
    private float moyenne;
    private double depenses;
    private String commentaire;

    public Membre() {
    }

    public Dossier getDossier() {
        if(dossier==null){
            dossier=new Dossier();
        }
        return dossier;
    }

    public Membre(ActiviteItem activiteItem, Dossier dossier, Long id, String nom, String prenom, String relationOrphelin, Date dateNaissance, String profession, String typeMetier, String niveauScolaire, String recruteur, String ecole, double salaire, float moyenne, double depenses, String commentaire) {
        this.activiteItem = activiteItem;
        this.dossier = dossier;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.relationOrphelin = relationOrphelin;
        this.dateNaissance = dateNaissance;
        this.profession = profession;
        this.typeMetier = typeMetier;
        this.niveauScolaire = niveauScolaire;
        this.recruteur = recruteur;
        this.ecole = ecole;
        this.salaire = salaire;
        this.moyenne = moyenne;
        this.depenses = depenses;
        this.commentaire = commentaire;
    }

    public ActiviteItem getActiviteItem() {
        return activiteItem;
    }

    public void setActiviteItem(ActiviteItem activiteItem) {
        this.activiteItem = activiteItem;
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

    
    
    public String getNom() {
        
        return nom;
        
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRelationOrphelin() {
        return relationOrphelin;
    }

    public void setRelationOrphelin(String relationOrphelin) {
        this.relationOrphelin = relationOrphelin;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getTypeMetier() {
        return typeMetier;
    }

    public void setTypeMetier(String typeMetier) {
        this.typeMetier = typeMetier;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }

    public String getRecruteur() {
        return recruteur;
    }

    public void setRecruteur(String recruteur) {
        this.recruteur = recruteur;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public double getDepenses() {
        return depenses;
    }

    public void setDepenses(double depenses) {
        this.depenses = depenses;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Membre other = (Membre) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Membre{" + "nom=" + nom + ", prenom=" + prenom + '}';
    }

    
    
    
    

    
    
}
