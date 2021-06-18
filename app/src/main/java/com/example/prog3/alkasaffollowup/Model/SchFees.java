package com.example.prog3.alkasaffollowup.Model;

/**
 * Created by prog3 on 3/12/2018.
 */

public class SchFees {

    String scope;
    String value;
    String contdate;
    String expdate;

    public SchFees(String scope, String value, String contdate, String expdate) {
        this.scope = scope;
        this.value = value;
        this.contdate = contdate;
        this.expdate = expdate;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getContdate() {
        return contdate;
    }

    public void setContdate(String contdate) {
        this.contdate = contdate;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }
}
