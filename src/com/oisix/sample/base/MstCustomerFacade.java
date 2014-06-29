/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.oisix.sample.base;

import com.oisix.sample.model.MstCustomer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author megascus
 */
@Stateless
public class MstCustomerFacade extends AbstractFacade<MstCustomer> {
    @PersistenceContext(unitName = "oi-webapp-samplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MstCustomerFacade() {
        super(MstCustomer.class);
    }
    
}
