package com.oisix.sample.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import com.oisix.sample.model.MstCustomer;

/**
 * MST_CUSTOMER table's data access object.
 */
public class MstCustomerDao {

	private final static String TABLE_NAME = MstCustomer.class.getSimpleName();

	private final static String SQL_FIND_BY_PK;
	
	static {
		StringBuilder buff;

		buff = new StringBuilder()
		.append("from ").append(TABLE_NAME).append(" ")
		.append("where ")
		.append("customerId = :customerId ");

		SQL_FIND_BY_PK = buff.toString();
	}
	
	public static void merge(Session session, MstCustomer mstCustomer) {
		Date now = new Date();
		mstCustomer.setCreateId("9999");
		mstCustomer.setCreateTime(now);
		mstCustomer.setUpdateId("9999");
		mstCustomer.setUpdateTime(now);
		session.merge(mstCustomer);
	}

	public static MstCustomer findByPk(Session session, String customerId) {
		Query query = session.createQuery(SQL_FIND_BY_PK);
		query.setString("customerId", customerId);
		return (MstCustomer)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public static List<MstCustomer> find(Session session, MstCustomer searchCondition) {
		StringBuilder buff = new StringBuilder()
		.append("from ").append(TABLE_NAME).append(" ")
		.append("where ");

                //TODO 検索条件を元に戻す
		//addSearchCodition(buff, "customerId", searchCondition.getCustomerId());
		//addSearchCoditionLike(buff, "fullname", searchCondition.getFullname());
		//addSearchCoditionLike(buff, "fullnameKana", searchCondition.getFullnameKana());
		//addSearchCodition(buff, "mailAddress", searchCondition.getMailAddress());
		//addSearchCodition(buff, "zipCode", searchCondition.getZipCode());
		//addSearchCodition(buff, "tel", searchCondition.getTel());
		buff.append("1 = 1 ");
		buff.append("order by customerId");

		Query query = session.createQuery(buff.toString());

		//setParameter(query, "customerId", searchCondition.getCustomerId());
		//setParameterLike(query, "fullname", searchCondition.getFullname());
		//setParameterLike(query, "fullnameKana", searchCondition.getFullnameKana());
		//setParameter(query, "mailAddress", searchCondition.getMailAddress());
		//setParameter(query, "zipCode", searchCondition.getZipCode());
		//setParameter(query, "tel", searchCondition.getTel());

		return query.list();
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
			query.setString(columnName, parameter);
		}
	}

	private static void setParameterLike(Query query, String columnName, String parameter) {
		if (!StringUtils.isEmpty(parameter)) {
			query.setString(columnName, "%" + parameter + "%");
		}
	}
}