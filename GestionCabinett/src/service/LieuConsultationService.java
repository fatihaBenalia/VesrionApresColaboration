/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.LieuConsultation;

import dao.LieuConsultationDao;
import java.util.List;

/**
 *
 * @author User
 */
public class LieuConsultationService {

   LieuConsultationDao lieuConsultationDao;
    
   public LieuConsultation findById(String id) throws Exception{
       return lieuConsultationDao.findById(id);
   }
   
   public List<LieuConsultation> findAll() throws Exception{
       return lieuConsultationDao.findAll();
   }
   
   
}
