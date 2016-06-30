/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.RemplirCaissePhilantrope;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class RemplirCaissePhilantropeFacade extends AbstractFacade<RemplirCaissePhilantrope> {
    @PersistenceContext(unitName = "GestionSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemplirCaissePhilantropeFacade() {
        super(RemplirCaissePhilantrope.class);
    }
    
}
