package com.oisix.sample.model;

import javax.persistence.Column;
import javax.persistence.Embedded;

import javax.persistence.Entity;

@Entity
public class MstCustomer extends EntityBase {

    @Column(unique = true)
    private String customerId;
    private String mailAddress;
    private String fullname;
    private String fullnameKana;
    @Embedded
    private Address address = new Address();
    @Embedded
    private TelephoneNumber tel = new TelephoneNumber();

    public MstCustomer() {
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMailAddress() {
        return this.mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullnameKana() {
        return this.fullnameKana;
    }

    public void setFullnameKana(String fullnameKana) {
        this.fullnameKana = fullnameKana;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ZipCode getZipCode() {
        return this.address.getZipCode();
    }

    public void setZipCode(ZipCode zipCode) {
        this.address.setZipCode(zipCode);
    }

    public void setZipCode1(String zipCode1) {
        this.address.getZipCode().setZip(zipCode1);
    }

    public void setZipCode2(String zipCode2) {
        this.address.getZipCode().setPlusFour(zipCode2);
    }

    public String getZipCode1() {
        return this.address.getZipCode().getZip();
    }

    public String getZipCode2() {
        return this.address.getZipCode().getPlusFour();
    }

    public String getTodofuken() {
        return this.address.getPrefecture();
    }

    public void setTodofuken(String todofuken) {
        this.address.setPrefecture(todofuken);
    }

    public String getAddress1() {
        return this.address.getCity();
    }

    public void setAddress1(String address1) {
        this.address.setCity(address1);
    }

    public String getAddress2() {
        return this.address.getStreet();
    }

    public void setAddress2(String address2) {
        this.address.setStreet(address2);
    }

    public String getTel() {
        return this.tel.toString();
    }

    public String getTel1() {
        return this.tel.getTop();
    }

    public String getTel2() {
        return this.tel.getMiddle();
    }

    public String getTel3() {
        return this.tel.getBottom();
    }

    public void setTel(TelephoneNumber tel) {
        this.tel = tel;
    }

    public void setTel1(String tel1) {
        this.tel.setTop(tel1);
    }

    public void setTel2(String tel2) {
        this.tel.setMiddle(tel2);
    }

    public void setTel3(String tel3) {
        this.tel.setBottom(tel3);
    }
}
