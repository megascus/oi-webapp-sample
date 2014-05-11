package com.oisix.sample.base;

import com.oisix.sample.model.MstCustomer;
import java.util.List;

/**
 *
 * @author megascus
 */
public class CustomerSearchBean {

    private MstCustomer searchCondition;
    private List<MstCustomer> results;

    public MstCustomer getSearchCondition() {
        return searchCondition;
    }

    public void setSearchCondition(MstCustomer searchCondition) {
        this.searchCondition = searchCondition;
    }

    public List<MstCustomer> getResults() {
        return results;
    }

    public void setResults(List<MstCustomer> results) {
        this.results = results;
    }

}
