/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.RemplissageItemPhilantrope;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class RemplissageItemPhilantropeFacade extends AbstractFacade<RemplissageItemPhilantrope> {
    @PersistenceContext(unitName = "GestionSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemplissageItemPhilantropeFacade() {
        super(RemplissageItemPhilantrope.class);
    }
    
}
