/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Ordonnance;
import dao.ordoDao;
import java.util.List;

/**
 *
 * @author HASNA
 */
public class ordoService {
    ordoDao ordDao= new ordoDao();
    
    
    
        public List<Ordonnance> findAll() throws Exception{
         return  ordDao.findAll();
    }
    
    public int save(Ordonnance ordonnace ) throws Exception {
        return ordDao.save(ordonnace);
    }

    public int update(Ordonnance ordonnace) throws Exception {
       return ordDao.update(ordonnace);
    }

    public int delete(Ordonnance ordonnance) throws Exception {
        return ordDao.delete(ordonnance);
    }
    
    
    
    
}
