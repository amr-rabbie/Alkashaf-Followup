package com.example.prog3.alkasaffollowup.Model;

/**
 * Created by prog3 on 3/17/2018.
 */

public class ProgSteg {
    String projref;
    String contdate;
    String progst;
    String dps;
    String wscope;
    String inprogdate;

    public ProgSteg(String projref, String contdate, String progst, String dps, String wscope,String inprogdate) {
        this.projref = projref;
        this.contdate = contdate;
        this.progst = progst;
        this.dps = dps;
        this.wscope = wscope;
        this.inprogdate=inprogdate;
    }

    public String getProjref() {
        return projref;
    }

    public void setProjref(String projref) {
        this.projref = projref;
    }

    public String getContdate() {
        return contdate;
    }

    public void setContdate(String contdate) {
        this.contdate = contdate;
    }

    public String getProgst() {
        return progst;
    }

    public void setProgst(String progst) {
        this.progst = progst;
    }

    public String getDps() {
        return dps;
    }

    public void setDps(String dps) {
        this.dps = dps;
    }

    public String getWscope() {
        return wscope;
    }

    public void setWscope(String wscope) {
        this.wscope = wscope;
    }

    public String getInprogdate() {
        return inprogdate;
    }

    public void setInprogdate(String inprogdate) {
        this.inprogdate = inprogdate;
    }
}
