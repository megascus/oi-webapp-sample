package com.oisix.sample.bean;

import com.oisix.sample.dao.MstCustomerDao;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.model.ZipCode;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * 顧客の検索をするクラスです。
 *
 * @author yamada-shouhei
 *
 */
public class CustomerSearchBean extends ModelBeanBase {

    private MstCustomer searchCondition = new MstCustomer();
    private List<MstCustomer> result = null;

    @Override
    public void validate() throws IOException, ServletException {
    }

    @Override
    public void process() {
        if (isClick("search")) {
            this.search();
        }
    }

    /**
     * 顧客を検索します。
     */
    public void search() {
        getParameter();

        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);

        try {
            factory.getCurrentSession().beginTransaction();

            this.result = MstCustomerDao.find(factory.getCurrentSession(), this.searchCondition);

            factory.getCurrentSession().getTransaction().commit();

        } catch (RuntimeException e) {
            e.printStackTrace();
            factory.getCurrentSession().getTransaction().rollback();
        } finally {
            factory.getCurrentSession().close();
        }
    }

    /**
     * リクエストパラメータを取得します。
     */
    private void getParameter() {
        this.searchCondition.setCustomerId(getParameterNvl("customerId"));
        this.searchCondition.setFullname(getParameterNvl("fullname"));
        this.searchCondition.setFullnameKana(getParameterNvl("fullnameKana"));
        this.searchCondition.setMailAddress(getParameterNvl("mailAddress"));
        this.searchCondition.setZipCode(new ZipCode(getParameterNvl("zipCode1"), getParameterNvl("zipCode2")));
        this.searchCondition.setTel1(getParameterNvl("tel1"));
        this.searchCondition.setTel2(getParameterNvl("tel2"));
        this.searchCondition.setTel3(getParameterNvl("tel3"));
    }

    public MstCustomer getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(MstCustomer searchCondition) {
        this.searchCondition = searchCondition;
    }

    public List<MstCustomer> getResult() {
        return result;
    }

    public void setResult(List<MstCustomer> result) {
        this.result = result;
    }
}
