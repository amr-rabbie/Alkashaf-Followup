package com.example.prog3.alkasaffollowup.Model;

/**
 * Created by prog3 on 3/12/2018.
 */

public class DesPay {

    String payname;
    String scope;
    String value;
    String notes;
    String paytype;

    public DesPay(String payname, String scope, String value, String notes, String paytype) {
        this.payname = payname;
        this.scope = scope;
        this.value = value;
        this.notes = notes;
        this.paytype = paytype;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }
}
