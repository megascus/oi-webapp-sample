package com.oisix.sample.model;

// Generated 2013/10/03 12:45:40 by Hibernate Tools 4.0.0
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MstCustomer implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String customerId;
    private String mailAddress;
    private String fullname;
    private String fullnameKana;
    @Embedded
    private Address address = new Address();
    @Embedded
    private TelephoneNumber tel = new TelephoneNumber();

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    private String createId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;
    private String updateId;

    public MstCustomer() {
    }

    public MstCustomer(String mailAddress, String fullname, String fullnameKana, ZipCode zipCode, String todofuken,
            String address1, String address2, TelephoneNumber tel, Date createTime, String createId, Date updateTime,
            String updateId) {
        this.mailAddress = mailAddress;
        this.fullname = fullname;
        this.fullnameKana = fullnameKana;
        this.address.setZipCode(zipCode);
        this.address.setPrefecture(todofuken);
        this.address.setCity(address1);
        this.address.setStreet(address2);
        this.tel = tel;
        this.createTime = createTime;
        this.createId = createId;
        this.updateTime = updateTime;
        this.updateId = updateId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        this.address.setCity(address2);
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

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateId() {
        return this.createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateId() {
        return this.updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        setCreateId("9999");
        setCreateTime(now);
        setUpdateId("9999");
        setUpdateTime(now);
    }

    @PreUpdate
    public void preUpdate() {
        Date now = new Date();
        setUpdateId("9999");
        setUpdateTime(now);
    }
}
