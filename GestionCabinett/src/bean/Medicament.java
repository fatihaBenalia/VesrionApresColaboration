/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author HASNA
 */
public class Medicament {
    private String id;
    
    private String nom;
    private String indication;
    private String contreIndication;
    private String libelle;
    private String forme;
    private String codeBarre;
    private String paysFabrication;
    private String LaboFabrication;
    private String formuleChimique;

    public Medicament() {
    }

    public Medicament(String id, String nom, String indication, String contreIndication, String libelle, String forme, String codeBarre, String paysFabrication, String LaboFabrication, String formuleChimique) {
        this.id = id;
        this.nom = nom;
        this.indication = indication;
        this.contreIndication = contreIndication;
        this.libelle = libelle;
        this.forme = forme;
        this.codeBarre = codeBarre;
        this.paysFabrication = paysFabrication;
        this.LaboFabrication = LaboFabrication;
        this.formuleChimique = formuleChimique;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getContreIndication() {
        return contreIndication;
    }

    public void setContreIndication(String contreIndication) {
        this.contreIndication = contreIndication;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getPaysFabrication() {
        return paysFabrication;
    }

    public void setPaysFabrication(String paysFabrication) {
        this.paysFabrication = paysFabrication;
    }

    public String getLaboFabrication() {
        return LaboFabrication;
    }

    public void setLaboFabrication(String LaboFabrication) {
        this.LaboFabrication = LaboFabrication;
    }

    public String getFormuleChimique() {
        return formuleChimique;
    }

    public void setFormuleChimique(String formuleChimique) {
        this.formuleChimique = formuleChimique;
    }

    @Override
    public String toString() {
        return "Medicament{" + "id=" + id + ", nom=" + nom + ", indication=" + indication + ", contreIndication=" + contreIndication + ", libelle=" + libelle + ", forme=" + forme + ", codeBarre=" + codeBarre + ", paysFabrication=" + paysFabrication + ", LaboFabrication=" + LaboFabrication + ", formuleChimique=" + formuleChimique + '}';
    }
    
    
    
}
