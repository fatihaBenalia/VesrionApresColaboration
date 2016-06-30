/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Patient;
import bean.RendezVous;
import dao.RDVDao;
import java.util.List;

/**
 *
 * @author HASNA
 */
public class RDVService {
    RDVDao rDVDao = new RDVDao();
    
     public  List<RendezVous> All() throws Exception{
        return rDVDao.findAll();
    }
   
   public RendezVous findById(String id) throws Exception{
       return rDVDao.findById(id);
   }
    public int save(RendezVous rendezVous) throws Exception {
        return rDVDao.save(rendezVous);
    }
      
    public List<RendezVous> findAll() throws Exception{
         return  rDVDao.findAll();
    }
    
   

    public int update(RendezVous rendezVous) throws Exception {
       return rDVDao.update(rendezVous);
    }

    public int delete(RendezVous rendezVous) throws Exception {
        return rDVDao.delete(rendezVous);
    }
    
}
