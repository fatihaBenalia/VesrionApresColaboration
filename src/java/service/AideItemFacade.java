/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.AideItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class AideItemFacade extends AbstractFacade<AideItem> {
    @PersistenceContext(unitName = "GestionSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AideItemFacade() {
        super(AideItem.class);
    }
    
    
public double CalculMontantTotal(List<AideItem> aideItems) {
        double montant = 0;
        for (AideItem AideItem : aideItems) {
            montant += AideItem.getMontantMensuelle();
        }
        return montant;
    }
}
