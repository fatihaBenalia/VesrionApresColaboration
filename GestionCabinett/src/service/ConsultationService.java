/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Consultation;

import dao.ConsultationDao;
import java.sql.Array;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author User
 */
public class ConsultationService {
    ConsultationDao consultationDao = new ConsultationDao();
    
    public List<Consultation> AllConsultation() throws Exception{
       return consultationDao.findAll();
    
}
    public int save(Consultation consultation) throws Exception {
                return consultationDao.save(consultation);
    } 
    
    public int delete(Consultation consultation) throws Exception {
        return consultationDao.delete(consultation);
    }
    public int update(Consultation consultation) throws Exception {
          return consultationDao.update(consultation);
      }   
    
    
    public int deleteAll(List<Consultation>consultations) throws SQLException{
        String reqeuette=" Delete From Consultation ";
                return consultationDao.execUpdate(reqeuette);
    }

public List<Consultation> recherche(String choix, String hadik) throws Exception {
        
    String requette= "SELECT * FROM Consultation where 1=1 ";
    
    if(choix != null && choix.equals("Numero de Consultation")){
         requette+=" AND id like '"+hadik+"'";
         
    }
      if(choix != null && choix.equals("Montant Total")){
         requette+=" AND MontantTotal like'"+hadik+"'";
         
    }
          if(choix != null && choix.equals("Montant Payé")){
         requette+=" AND MontantPayé like '"+hadik+"'";
         
    }
              if(choix != null && choix.equals("lieu Consultation")){
         requette+=" AND lieuConsultation like '%"+hadik+"%'";
         
    }
      return consultationDao.load(requette);
        
    }
    


public List<Consultation> recherche2(Date date)  {
        
        try {
            String requette= "SELECT * FROM Consultation where 1=1 ";
            System.out.println(" date==>"+date);
            if (date != null) {
                requette += " and dateConsultation = '" + date + "'";
            }
            return consultationDao.load(requette);
        } catch (Exception ex) {
            Logger.getLogger(ConsultationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
}





















}
