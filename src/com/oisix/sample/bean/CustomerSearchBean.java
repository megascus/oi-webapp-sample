package com.oisix.sample.bean;

import com.oisix.sample.dao.MstCustomerRepository;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.model.ZipCode;
import java.io.IOException;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.servlet.ServletException;

/**
 * 顧客の検索をするクラスです。
 *
 * @author yamada-shouhei
 *
 */
@Stateful
public class CustomerSearchBean extends ModelBeanBase {

    @Inject
    private MstCustomerRepository mstCustomerRepository;

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
        this.result = mstCustomerRepository.findByCondition(this.searchCondition);

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
