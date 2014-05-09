package com.oisix.sample.bean;

import java.util.List;


import com.oisix.sample.dao.MstCustomerRepository;
import com.oisix.sample.model.MstCustomer;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CustomerService {

    @Inject
    private MstCustomerRepository mstCustomerRepository;

    public void edit(MstCustomer mstCustomer) {
        Optional<MstCustomer> entity = mstCustomerRepository.findByCustomerId(mstCustomer.getCustomerId());
        if (entity.isPresent()) {
            MstCustomer existence = entity.get();
            existence.setFullname(mstCustomer.getFullname());
            existence.setFullnameKana(mstCustomer.getFullnameKana());
            existence.setMailAddress(mstCustomer.getMailAddress());
            existence.setAddress(mstCustomer.getAddress());
            existence.setTel(mstCustomer.getTel());
        } else {
            mstCustomerRepository.merge(mstCustomer);
        }
    }

    public List<MstCustomer> search(MstCustomer searchCondition) {
        return mstCustomerRepository.findByCondition(searchCondition);
    }

    public Optional<MstCustomer> find(String customerId) {
        return mstCustomerRepository.findByCustomerId(customerId);
    }
}
