/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Profession;
import dao.ProfessionDao;

/**
 *
 * @author HASNA
 */
public class ProfessionService {
    
    ProfessionDao professionDao = new ProfessionDao();
    
    public Profession findById(String id) throws Exception
    {
        return professionDao.findById(id);
    }
   
    
}
