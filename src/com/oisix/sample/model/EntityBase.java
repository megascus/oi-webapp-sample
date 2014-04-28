/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * すべてのエンティティが持つべき情報を表します。 全てのエンティティはこのクラスを継承して下さい。 MappedSuperclassについては以下を参照。
 * http://docs.oracle.com/javaee/6/tutorial/doc/bnbqn.html
 *
 * @author megascus
 */
@MappedSuperclass
public abstract class EntityBase implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    protected String createId;
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date createTime;

    protected String updateId;
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public String getUpdateId() {
        return this.updateId;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getCreateId() {
        return this.createId;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    @Override
    public int hashCode() {
        if (id == null) {
            return 0;
        }
        return id.hashCode();
    }

    /**
     * エンティティを比較します。 
     * 本来はbusinessキーで行ったほうが良いかもしれない
     * http://stackoverflow.com/questions/2446590/entities-equals-hashcode-and-tostring-how-to-correctly-implement-them
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.id, ((EntityBase) obj).hashCode());
    }

}
