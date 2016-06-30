/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author HASNA
 */

public class Patient {
    
    private String id;
    private String img;
    private String prenom;
    private String Nom;
    private String nomMari;
    private String prenomPere;
    private Date dateNaissance;
    private Date dateEnregistrement;
    private String sexe;
    private int age;
    private String profession;
    private String etatCivil;
    private int nbrEnfant;
    private Date dateDeces;
    private String pays;
    private String ville;
    private String adresse;
    private String Telfix;
    private String telMobile;
    private String email;
    private String codePostal;

    public Patient(String id, String img, String prenom, String Nom, String nomMari, String prenomPere, Date dateNaissance, Date dateEnregistrement, String sexe, int age, String profession, String etatCivil, int nbrEnfant, Date dateDeces, String pays, String ville, String adresse, String Telfix, String telMobile, String email, String codePostal) {
        this.id = id;
        this.img = img;
        this.prenom = prenom;
        this.Nom = Nom;
        this.nomMari = nomMari;
        this.prenomPere = prenomPere;
        this.dateNaissance = dateNaissance;
        this.dateEnregistrement = dateEnregistrement;
        this.sexe = sexe;
        this.age = age;
        this.profession = profession;
        this.etatCivil = etatCivil;
        this.nbrEnfant = nbrEnfant;
        this.dateDeces = dateDeces;
        this.pays = pays;
        this.ville = ville;
        this.adresse = adresse;
        this.Telfix = Telfix;
        this.telMobile = telMobile;
        this.email = email;
        this.codePostal = codePostal;
    }

   

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    

   
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getNomMari() {
        return nomMari;
    }

    public void setNomMari(String nomMari) {
        this.nomMari = nomMari;
    }

    public String getPrenomPere() {
        return prenomPere;
    }

    public void setPrenomPere(String prenomPere) {
        this.prenomPere = prenomPere;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEtatCivil() {
        return etatCivil;
    }

    public void setEtatCivil(String etatCivil) {
        this.etatCivil = etatCivil;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

   

    public int getNbrEnfant() {
        return nbrEnfant;
    }

    public void setNbrEnfant(int nbrEnfant) {
        this.nbrEnfant = nbrEnfant;
    }

    public Date getDateDeces() {
        return dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

  

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelfix() {
        return Telfix;
    }

    public void setTelfix(String Telfix) {
        this.Telfix = Telfix;
    }

    public String getTelMobile() {
        return telMobile;
    }

    public void setTelMobile(String telMobile) {
        this.telMobile = telMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", img=" + img + ", prenom=" + prenom + ", Nom=" + Nom + ", nomMari=" + nomMari + ", prenomPere=" + prenomPere + ", dateNaissance=" + dateNaissance + ", dateEnregistrement=" + dateEnregistrement + ", sexe=" + sexe + ", age=" + age + ", profession=" + profession + ", etatCivil=" + etatCivil + ", nbrEnfant=" + nbrEnfant + ", dateDeces=" + dateDeces + ", pays=" + pays + ", ville=" + ville + ", adresse=" + adresse + ", Telfix=" + Telfix + ", telMobile=" + telMobile + ", email=" + email + ", codePostal=" + codePostal + '}';
    }

   

    public Patient() {
    }

   

  
   
   
    
}
