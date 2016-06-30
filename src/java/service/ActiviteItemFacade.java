/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ActiviteItem;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author User
 */
@Stateless
public class ActiviteItemFacade extends AbstractFacade<ActiviteItem> {
    @PersistenceContext(unitName = "GestionSocialPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActiviteItemFacade() {
        super(ActiviteItem.class);
    }
    
public double CalculMontantTotal(List<ActiviteItem> activiteItems) {
        double montant = 0;
        for (ActiviteItem activiteItem : activiteItems) {
            montant += activiteItem.getMontantMonsuel();
        }
        return montant;
    }
}
