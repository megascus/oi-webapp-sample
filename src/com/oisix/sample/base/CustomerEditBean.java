package com.oisix.sample.base;

import com.oisix.sample.model.MstCustomer;
import java.util.List;

/**
 *
 * @author megascus
 */
public class CustomerEditBean {

    private String actionMessage;
    private MstCustomer mstCustomer = new MstCustomer();
    private List<String> errors;
    private boolean change = false;

    public String getActionMessage() {
        return actionMessage;
    }

    public void setActionMessage(String actionMessage) {
        this.actionMessage = actionMessage;
    }

    public MstCustomer getMstCustomer() {
        return mstCustomer;
    }

    public void setMstCustomer(MstCustomer mstCustomer) {
        this.mstCustomer = mstCustomer;
    }

    public String getViewTitle() {
        return change ? "編集" : "登録";
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public boolean isChange() {
        return change;
    }

    public void setChange(boolean change) {
        this.change = change;
    }
}
