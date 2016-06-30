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
public class Ordonnance {
    private int id;
    private Patient patient;
    private String nomMedecin;
    private String adresseCabinet;
    private String TelFix;
    private String webOrEmail;
    private String textOrdo;
    private String Medicament1;
    private String Medicament2;
    private String Medicament3;
    private  int dose1;
    private  int dose2;
    private  int dose3;
    private String nmbrMedic1ParJour;
    private String nmbrMedic2ParJour;
    private String nmbrMedic3ParJour;
    private String dureeQSP;
    private String specialite;
    
    

    public Ordonnance() {
    }

    public Ordonnance(int id, Patient patient, String nomMedecin, String adresseCabinet, String TelFix, String webOrEmail, String textOrdo, String Medicament1, String Medicament2, String Medicament3, int dose1, int dose2, int dose3, String nmbrMedic1ParJour, String nmbrMedic2ParJour, String nmbrMedic3ParJour, String dureeQSP, String specialite) {
        this.id = id;
        this.patient = patient;
        this.nomMedecin = nomMedecin;
        this.adresseCabinet = adresseCabinet;
        this.TelFix = TelFix;
        this.webOrEmail = webOrEmail;
        this.textOrdo = textOrdo;
        this.Medicament1 = Medicament1;
        this.Medicament2 = Medicament2;
        this.Medicament3 = Medicament3;
        this.dose1 = dose1;
        this.dose2 = dose2;
        this.dose3 = dose3;
        this.nmbrMedic1ParJour = nmbrMedic1ParJour;
        this.nmbrMedic2ParJour = nmbrMedic2ParJour;
        this.nmbrMedic3ParJour = nmbrMedic3ParJour;
        this.dureeQSP = dureeQSP;
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getNomMedecin() {
        return nomMedecin;
    }

    public void setNomMedecin(String nomMedecin) {
        this.nomMedecin = nomMedecin;
    }

    public String getAdresseCabinet() {
        return adresseCabinet;
    }

    public void setAdresseCabinet(String adresseCabinet) {
        this.adresseCabinet = adresseCabinet;
    }

    public String getTelFix() {
        return TelFix;
    }

    public void setTelFix(String TelFix) {
        this.TelFix = TelFix;
    }

    public String getWebOrEmail() {
        return webOrEmail;
    }

    public void setWebOrEmail(String webOrEmail) {
        this.webOrEmail = webOrEmail;
    }

    public String getTextOrdo() {
        return textOrdo;
    }

    public void setTextOrdo(String textOrdo) {
        this.textOrdo = textOrdo;
    }

    public String getMedicament1() {
        return Medicament1;
    }

    public void setMedicament1(String Medicament1) {
        this.Medicament1 = Medicament1;
    }

    public String getMedicament2() {
        return Medicament2;
    }

    public void setMedicament2(String Medicament2) {
        this.Medicament2 = Medicament2;
    }

    public String getMedicament3() {
        return Medicament3;
    }

    public void setMedicament3(String Medicament3) {
        this.Medicament3 = Medicament3;
    }

    public int getDose1() {
        return dose1;
    }

    public void setDose1(int dose1) {
        this.dose1 = dose1;
    }

    public int getDose2() {
        return dose2;
    }

    public void setDose2(int dose2) {
        this.dose2 = dose2;
    }

    public int getDose3() {
        return dose3;
    }

    public void setDose3(int dose3) {
        this.dose3 = dose3;
    }

    public String getNmbrMedic1ParJour() {
        return nmbrMedic1ParJour;
    }

    public void setNmbrMedic1ParJour(String nmbrMedic1ParJour) {
        this.nmbrMedic1ParJour = nmbrMedic1ParJour;
    }

    public String getNmbrMedic2ParJour() {
        return nmbrMedic2ParJour;
    }

    public void setNmbrMedic2ParJour(String nmbrMedic2ParJour) {
        this.nmbrMedic2ParJour = nmbrMedic2ParJour;
    }

    public String getNmbrMedic3ParJour() {
        return nmbrMedic3ParJour;
    }

    public void setNmbrMedic3ParJour(String nmbrMedic3ParJour) {
        this.nmbrMedic3ParJour = nmbrMedic3ParJour;
    }

    public String getDureeQSP() {
        return dureeQSP;
    }

    public void setDureeQSP(String dureeQSP) {
        this.dureeQSP = dureeQSP;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    @Override
    public String toString() {
        return id+"";
    }

    

    
}
