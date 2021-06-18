package com.example.prog3.alkasaffollowup.Model;

/**
 * Created by prog3 on 3/13/2018.
 */

public class ReqFolUp {

    String projname;
    String projsn;
    String reqname;
    String pername;
    String scope;
    String status;
    String actiondate;
    String comment;
    String nextfolup;

    public ReqFolUp(String projname, String projsn, String reqname, String pername, String scope, String status, String actiondate, String comment, String nextfolup) {
        this.projname = projname;
        this.projsn = projsn;
        this.reqname = reqname;
        this.pername = pername;
        this.scope = scope;
        this.status = status;
        this.actiondate = actiondate;
        this.comment = comment;
        this.nextfolup = nextfolup;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getProjsn() {
        return projsn;
    }

    public void setProjsn(String projsn) {
        this.projsn = projsn;
    }

    public String getReqname() {
        return reqname;
    }

    public void setReqname(String reqname) {
        this.reqname = reqname;
    }

    public String getPername() {
        return pername;
    }

    public void setPername(String pername) {
        this.pername = pername;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActiondate() {
        return actiondate;
    }

    public void setActiondate(String actiondate) {
        this.actiondate = actiondate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getNextfolup() {
        return nextfolup;
    }

    public void setNextfolup(String nextfolup) {
        this.nextfolup = nextfolup;
    }
}
