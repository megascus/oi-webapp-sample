package com.oisix.sample.bean;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.oisix.sample.dao.MstCustomerRepository;
import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.validator.Address1Validator;
import com.oisix.sample.validator.Address2Validator;
import com.oisix.sample.validator.FullnameKanaValidator;
import com.oisix.sample.validator.FullnameValidator;
import com.oisix.sample.validator.MailAddressValidator;
import com.oisix.sample.validator.TelValidator;
import com.oisix.sample.validator.TodofukenValidator;
import com.oisix.sample.validator.ZipCodeValidator;
import java.util.Optional;
import javax.ejb.Stateful;
import javax.inject.Inject;

@Stateful
public class CustomerEditBean extends ModelBeanBase {

    @Inject
    private MstCustomerRepository mstCustomerRepository;

    private MstCustomer mstCustomer = new MstCustomer();

    @Override
    public void validate() {

        if (isClick("edit")) {
            this.getParameter();
            List<String> errors = super.getErrors();

            new FullnameValidator(errors).validate(this.mstCustomer.getFullname());
            new FullnameKanaValidator(errors).validate(this.mstCustomer.getFullnameKana());
            new MailAddressValidator(errors).validate(this.mstCustomer.getMailAddress());
            new ZipCodeValidator(errors).validate(this.mstCustomer.getZipCode1() + "-" + this.mstCustomer.getZipCode2());
            new TodofukenValidator(errors).validate(this.mstCustomer.getTodofuken());
            new Address1Validator(errors).validate(this.mstCustomer.getAddress1());
            new Address2Validator(errors).validate(this.mstCustomer.getAddress2());
            new TelValidator(errors).validate(this.mstCustomer.getTel1(), this.mstCustomer.getTel2(), this.mstCustomer.getTel3());
        }
        super.setErrors(errors);
    }

    @Override
    public void process() {
        this.mstCustomer.setCustomerId(getParameterNvl("customerId"));

        if (isClick("edit")) {
            this.edit();
        } else if (!StringUtils.isEmpty(this.mstCustomer.getCustomerId())) {
            search();
            request.setAttribute("mstCustomer", this.mstCustomer);
        }
    }

    public void search() {
        this.mstCustomer = mstCustomerRepository.findByCustomerId(mstCustomer.getCustomerId()).get();
    }

    public void edit() {
        if (super.isError()) {
            return;
        }
        try {
            Optional<MstCustomer> entity = mstCustomerRepository.findByCustomerId(mstCustomer.getCustomerId());
            if (entity.isPresent()) {
                MstCustomer existence = entity.get();
                existence.setFullname(mstCustomer.getFullname());
                existence.setFullnameKana(mstCustomer.getFullnameKana());
                existence.setMailAddress(mstCustomer.getMailAddress());
                existence.setAddress(mstCustomer.getAddress());
                existence.setTel(mstCustomer.getTel());
                mstCustomer = existence;
            }
            mstCustomerRepository.merge(mstCustomer);
            super.setActionMessage(getViewTitle() + "完了しました。");

        } catch (RuntimeException e) {
            super.setActionMessage(getViewTitle() + "に失敗しました。");
        }
    }

    public MstCustomer getMstCustomer() {
        return mstCustomer;
    }

    public void setMstCustomer(MstCustomer mstCustomer) {
        this.mstCustomer = mstCustomer;
    }

    public String getViewTitle() {
        if (StringUtils.isEmpty(this.mstCustomer.getCustomerId())) {
            return "登録";
        } else {
            return "更新";
        }
    }

    private void getParameter() {
        this.mstCustomer.setCustomerId(getParameterNvl("customerId"));
        this.mstCustomer.setFullname(getParameterNvl("fullname"));
        this.mstCustomer.setFullnameKana(getParameterNvl("fullnameKana"));
        this.mstCustomer.setMailAddress(getParameterNvl("mailAddress"));
        this.mstCustomer.setZipCode1(getParameterNvl("zipCode1"));
        this.mstCustomer.setZipCode2(getParameterNvl("zipCode2"));
        this.mstCustomer.setTodofuken(getParameterNvl("todofuken"));
        this.mstCustomer.setAddress1(getParameterNvl("address1"));
        this.mstCustomer.setAddress2(getParameterNvl("address2"));
        this.mstCustomer.setTel1(getParameterNvl("tel1"));
        this.mstCustomer.setTel2(getParameterNvl("tel2"));
        this.mstCustomer.setTel3(getParameterNvl("tel3"));
    }
}
