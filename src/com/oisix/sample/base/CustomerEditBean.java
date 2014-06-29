package com.oisix.sample.base;

import com.oisix.sample.bean.CustomerService;
import com.oisix.sample.model.MstCustomer;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author megascus
 */
@ViewScoped
@Named(value = "customerEdit")
public class CustomerEditBean {

    private String actionMessage;
    private MstCustomer mstCustomer = new MstCustomer();
    private List<String> errors;
    private boolean change = false;

    @Inject
    CustomerService service;

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

    public String update() {
        try {
            service.edit(mstCustomer);
            this.setActionMessage(this.getViewTitle() + "完了しました。");
        } catch (Exception e) {
            this.setActionMessage(this.getViewTitle() + "に失敗しました。");
        }
        this.setMstCustomer(mstCustomer);

        return null;
    }
}
