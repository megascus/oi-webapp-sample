/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.dao;

import com.oisix.sample.model.MstCustomer;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author megascus
 */
@Stateless
public class MstCustomerRepository extends AbstractRepository<MstCustomer> {

    @PersistenceContext(unitName = "oi-webapp-samplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MstCustomerRepository() {
        super(MstCustomer.class);
    }

    public Optional<MstCustomer> findByCustomerId(String customerId) {
        MstCustomer c = (MstCustomer) em.createQuery("select c from MstCustomer c where c.customerId = :customerId").setParameter("customerId", customerId).getSingleResult();
        return Optional.ofNullable(c);
    }

    @SuppressWarnings("unchecked")
    public List<MstCustomer> findByCondition(MstCustomer searchCondition) {
        StringBuilder buff = new StringBuilder()
                .append("select e from ").append(MstCustomer.class.getSimpleName()).append(" e ")
                .append("where ");

        //TODO 検索条件を元に戻す
        //addSearchCodition(buff, "customerId", searchCondition.getCustomerId());
        //addSearchCoditionLike(buff, "fullname", searchCondition.getFullname());
        //addSearchCoditionLike(buff, "fullnameKana", searchCondition.getFullnameKana());
        //addSearchCodition(buff, "mailAddress", searchCondition.getMailAddress());
        //addSearchCodition(buff, "zipCode", searchCondition.getZipCode());
        //addSearchCodition(buff, "tel", searchCondition.getTel());
        buff.append("1 = 1 ");
        buff.append("order by e.customerId");

        Query query = em.createQuery(buff.toString());

        //setParameter(query, "customerId", searchCondition.getCustomerId());
        //setParameterLike(query, "fullname", searchCondition.getFullname());
        //setParameterLike(query, "fullnameKana", searchCondition.getFullnameKana());
        //setParameter(query, "mailAddress", searchCondition.getMailAddress());
        //setParameter(query, "zipCode", searchCondition.getZipCode());
        //setParameter(query, "tel", searchCondition.getTel());
        return query.getResultList();
    }

    private static void addSearchCodition(StringBuilder buff, String columnName, String parameter) {
        if (!StringUtils.isEmpty(parameter)) {
            buff.append(" ").append(columnName).append(" = :").append(columnName).append(" and ");
        }
    }

    private static void addSearchCoditionLike(StringBuilder buff, String columnName, String parameter) {
        if (!StringUtils.isEmpty(parameter)) {
            buff.append(" ").append(columnName).append(" like :").append(columnName).append(" and ");
        }
    }

    private static void setParameter(Query query, String columnName, String parameter) {
        if (!StringUtils.isEmpty(parameter)) {
            query.setParameter(columnName, parameter);
        }
    }

    private static void setParameterLike(Query query, String columnName, String parameter) {
        if (!StringUtils.isEmpty(parameter)) {
            query.setParameter(columnName, "%" + parameter + "%");
        }
    }

}
