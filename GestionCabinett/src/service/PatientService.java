/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Patient;
import dao.PatientDao;
import java.util.List;

/**
 *
 * @author User
 */
public class PatientService {
    PatientDao patientDao=new PatientDao();
     Patient patient = new Patient();
    
   public  List<Patient> AllPatient() throws Exception{
        return patientDao.findAll();
    }
   
   public Patient findById(String id) throws Exception{
       return patientDao.findById(id);
   }
    public int save(Patient patient) throws Exception {
        return patientDao.save(patient);
    }
 
    
    
    public List<Patient> recherche(String choix, String hadik) throws Exception {
        
    String requette= "SELECT * FROM Patient where 1=1 ";
    if(choix != null && choix.equals("nom")){
         requette+=" AND nom like '"+hadik+"'";
         
    }
    if(choix != null && choix.equals("Numero de dossier")){
         requette+=" AND id like '"+hadik+"'";
         
    }
      if(choix != null && choix.equals("Age")){
         requette+=" AND age like'"+hadik+"'";
         
    }
          if(choix != null && choix.equals("Prenom")){
         requette+=" AND prenom like '"+hadik+"'";
         
    }
              if(choix != null && choix.equals("Profession")){
         requette+=" AND profession like '"+hadik+"'";
         
    }
                  if(choix != null && choix.equals("ville")){
         requette+=" AND ville like '"+hadik+"'";
         
    }
    
                
      return patientDao.load(requette);
        
    }
    
    
     public List<Patient> tri(String choix) throws Exception {
        
    String requette= "SELECT * FROM Patient where 1=1 ";
    if(choix != null && choix.equals("nom")){
         requette+=" order by nom desc '";
         
    }
   
      if(choix != null && choix.equals("Age")){
         requette+=" order by age desc ";
         
    }
          if(choix != null && choix.equals("Prenom")){
         requette+=" order by prenom desc ";
         
    }
              if(choix != null && choix.equals("Profession")){
         requette+=" order by profession desc ";
         
    }
                  if(choix != null && choix.equals("ville")){
         requette+=" order by ville desc ";
         
    }
    
                
      return patientDao.load(requette);
        
    }
    
    
    
    public List<Patient> findProduitByVille() throws Exception {
        Patient loadedPatient = patientDao.findById(patient.getId());
        if (loadedPatient != null) {
            String requette = "select * from Patient where ville = " + loadedPatient.getVille();
            return patientDao.load(requette);
            
        }
        return null;

    }
    
    
      public List<Patient> TriParAge() throws Exception {
      
            String requette = "select * from Patient order by age ";
            return patientDao.load(requette);
        
    }
    
       public List<Patient> TriParNom() throws Exception {
      
            String requette = "select * from Patient order by nom ";
            return patientDao.load(requette);
        
    }
    
    
 public void supprimerTous(List<Patient>patients) throws Exception{
     String requette="delete from Patient";
      patientDao.execUpdate(requette);
 }
     
   
      
    public List<Patient> findAll() throws Exception{
         return  patientDao.findAll();
    }
    
   

    public int update(Patient patient) throws Exception {
       return patientDao.update(patient);
    }

    public int delete(Patient patient) throws Exception {
        return patientDao.delete(patient);
    }
      
      
     
   
   
   
}
