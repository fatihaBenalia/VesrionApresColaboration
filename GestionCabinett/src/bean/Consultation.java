/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author HASNA
 */
public class Consultation {

    private int id;
    private Date dateConsultation;
    private String type;
    private int heure;
    private int minute;
    private String Motifconsultation;
    private int taille;
    private int poids;
    private int temperature;
    private int tensionMax;
    private int tensionMin;
    private String EtatPaiement;
    private Double MontantTotal;
    private Double MontantPayé;
    private Patient patient;
    private String lieuConsultation;

    public Consultation() {
    }

    public Consultation(Double MontantPayé,Double MontantTotal,String lieuConsultation, int id, Date dateConsultation, int minute, String type, int heure, String Motifconsultation, int taille, int poids, int temperature, int tensionMax, int tensionMin, Patient patient) {
        this.id = id;
        this.dateConsultation = dateConsultation;
        this.minute = minute;
        this.type = type;
        this.heure = heure;
        this.Motifconsultation = Motifconsultation;
        this.taille = taille;
        this.poids = poids;
        this.temperature = temperature;
        this.tensionMax = tensionMax;
        this.tensionMin = tensionMin;
        this.patient = patient;
        this.lieuConsultation = lieuConsultation;
        this.MontantPayé=MontantPayé;
        this.MontantTotal=MontantTotal;
    }

    public Double getMontantTotal() {
        return MontantTotal;
    }

    public void setMontantTotal(Double MontantTotal) {
        this.MontantTotal = MontantTotal;
    }

    public Double getMontantPayé() {
        return MontantPayé;
    }

    public void setMontantPayé(Double MontantPayé) {
        this.MontantPayé = MontantPayé;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLieuConsultation() {
        return lieuConsultation;
    }

    public void setLieuConsultation(String lieuConsultation) {
        this.lieuConsultation = lieuConsultation;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public Date getDateConsultation() {
        return dateConsultation;
    }

    public void setDateConsultation(Date dateConsultation) {
        this.dateConsultation = dateConsultation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHeure() {
        return heure;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public String getMotifconsultation() {
        return Motifconsultation;
    }

    public void setMotifconsultation(String Motifconsultation) {
        this.Motifconsultation = Motifconsultation;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTensionMax() {
        return tensionMax;
    }

    public void setTensionMax(int tensionMax) {
        this.tensionMax = tensionMax;
    }

    public int getTensionMin() {
        return tensionMin;
    }

    public void setTensionMin(int tensionMin) {
        this.tensionMin = tensionMin;
    }

    public String getEtatPaiement() {
        return EtatPaiement;
    }

    public void setEtatPaiement(String EtatPaiement) {
        this.EtatPaiement = EtatPaiement;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return id+"";
    }

   
}
