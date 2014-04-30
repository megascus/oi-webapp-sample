package com.oisix.sample.test;

import com.oisix.sample.dao.MstCustomerRepository;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.model.TelephoneNumber;
import com.oisix.sample.model.ZipCode;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MstCustomerData {

    @Inject
    MstCustomerRepository repository;
    
    public void create() {
        //FIXME 一意制約
        try {
            MstCustomer customer = new MstCustomer();
            customer.setCustomerId("1");
            customer.setMailAddress("test1@oisix.co.jp");
            customer.setFullname("おい六 一郎");
            customer.setFullnameKana("オイロク イチロウ");
            customer.setZipCode(new ZipCode("141", "0012"));
            customer.setTodofuken("東京都");
            customer.setAddress1("東京都品川区東五反田1丁目13番12号");
            customer.setAddress2("いちご五反田ビル");
            customer.setTel(new TelephoneNumber("03", "1234", "5678"));
            repository.merge(customer);
        } catch (Exception ignored) {
        }
    }
}
