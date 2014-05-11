/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.base;

import com.oisix.sample.model.MstCustomer;
import com.oisix.sample.validator.Address1Validator;
import com.oisix.sample.validator.Address2Validator;
import com.oisix.sample.validator.FullnameKanaValidator;
import com.oisix.sample.validator.FullnameValidator;
import com.oisix.sample.validator.MailAddressValidator;
import com.oisix.sample.validator.TelValidator;
import com.oisix.sample.validator.TodofukenValidator;
import com.oisix.sample.validator.ZipCodeValidator;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author megascus
 */
final class MstCustomerUtils {

    static String getParameterNvl(HttpServletRequest req, String key) {
        String s = req.getParameter(key);
        return StringUtils.trimToEmpty(s);
    }

    static MstCustomer convertParameter(HttpServletRequest req) {
        MstCustomer mstCustomer = new MstCustomer();
        try {
            mstCustomer.setId(Long.valueOf(getParameterNvl(req, "id")));
        } catch (Exception ignored) {
        }
        mstCustomer.setCustomerId(getParameterNvl(req, "customerId"));
        mstCustomer.setFullname(getParameterNvl(req, "fullname"));
        mstCustomer.setFullnameKana(getParameterNvl(req, "fullnameKana"));
        mstCustomer.setMailAddress(getParameterNvl(req, "mailAddress"));
        mstCustomer.setZipCode1(getParameterNvl(req, "zipCode1"));
        mstCustomer.setZipCode2(getParameterNvl(req, "zipCode2"));
        mstCustomer.setTodofuken(getParameterNvl(req, "todofuken"));
        mstCustomer.setAddress1(getParameterNvl(req, "address1"));
        mstCustomer.setAddress2(getParameterNvl(req, "address2"));
        mstCustomer.setTel1(getParameterNvl(req, "tel1"));
        mstCustomer.setTel2(getParameterNvl(req, "tel2"));
        mstCustomer.setTel3(getParameterNvl(req, "tel3"));
        return mstCustomer;
    }

    static List<String> validate(MstCustomer mstCustomer) {
        List<String> errors = new ArrayList<String>();

        new FullnameValidator(errors).validate(mstCustomer.getFullname());
        new FullnameKanaValidator(errors).validate(mstCustomer.getFullnameKana());
        new MailAddressValidator(errors).validate(mstCustomer.getMailAddress());
        new ZipCodeValidator(errors).validate(mstCustomer.getZipCode1() + "-" + mstCustomer.getZipCode2());
        new TodofukenValidator(errors).validate(mstCustomer.getTodofuken());
        new Address1Validator(errors).validate(mstCustomer.getAddress1());
        new Address2Validator(errors).validate(mstCustomer.getAddress2());
        new TelValidator(errors).validate(mstCustomer.getTel1(), mstCustomer.getTel2(), mstCustomer.getTel3());
        return errors;
    }
}
