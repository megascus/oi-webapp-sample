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
public class TelephoneNumber implements Serializable {

    private String top;
    private String middle;
    private String bottom;

    public TelephoneNumber() {
    }

    public TelephoneNumber(String top, String middle, String bottom) {
        this.top = top;
        this.middle = middle;
        this.bottom = bottom;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.top);
        hash = 11 * hash + Objects.hashCode(this.middle);
        hash = 11 * hash + Objects.hashCode(this.bottom);
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
        final TelephoneNumber other = (TelephoneNumber) obj;
        if (!Objects.equals(this.top, other.top)) {
            return false;
        }
        if (!Objects.equals(this.middle, other.middle)) {
            return false;
        }
        if (!Objects.equals(this.bottom, other.bottom)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return top + "-" + middle + "-" + bottom;
    }
}
