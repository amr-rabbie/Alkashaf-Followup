package com.example.prog3.alkasaffollowup.Model;

/**
 * Created by prog3 on 3/13/2018.
 */

public class PermFolUp {

    String permid;
    String projref;
    String permtype;
    String lstatus;
    String date;
    String address;

    public PermFolUp(String permid, String projref, String permtype, String lstatus, String date, String address) {
        this.permid = permid;
        this.projref = projref;
        this.permtype = permtype;
        this.lstatus = lstatus;
        this.date = date;
        this.address = address;
    }

    public String getPermid() {
        return permid;
    }

    public void setPermid(String permid) {
        this.permid = permid;
    }

    public String getProjref() {
        return projref;
    }

    public void setProjref(String projref) {
        this.projref = projref;
    }

    public String getPermtype() {
        return permtype;
    }

    public void setPermtype(String permtype) {
        this.permtype = permtype;
    }

    public String getLstatus() {
        return lstatus;
    }

    public void setLstatus(String lstatus) {
        this.lstatus = lstatus;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
