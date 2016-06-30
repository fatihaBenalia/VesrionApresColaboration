/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import bean.Motif;
import dao.MotifDao;
import java.util.List;

/**
 *
 * @author User
 */
public class MotifService {
    
    MotifDao motifDao = new MotifDao();
    public  List<Motif> AllMotif() throws Exception{
        return motifDao.findAll();
    }
    
    
    
    
    
}


