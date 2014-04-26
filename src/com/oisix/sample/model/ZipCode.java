/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oisix.sample.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author megascus
 */
@Embeddable
public class ZipCode implements Serializable {

    private String zip;
    private String plusFour;

    public ZipCode() {
    }

    public ZipCode(String zip, String plusFour) {
        this.zip = zip;
        this.plusFour = plusFour;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.zip);
        hash = 97 * hash + Objects.hashCode(this.plusFour);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ZipCode other = (ZipCode) obj;
        if (!Objects.equals(this.zip, other.zip)) {
            return false;
        }
        if (!Objects.equals(this.plusFour, other.plusFour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return zip + "-" + plusFour;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPlusFour() {
        return plusFour;
    }

    public void setPlusFour(String plusFour) {
        this.plusFour = plusFour;
    }
}
