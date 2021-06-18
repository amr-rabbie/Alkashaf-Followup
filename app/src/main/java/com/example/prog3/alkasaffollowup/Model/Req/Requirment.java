
package com.example.prog3.alkasaffollowup.Model.Req;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Requirment {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("RequuirementName")
    @Expose
    private String requuirementName;
    @SerializedName("PermitName")
    @Expose
    private String permitName;
    @SerializedName("Scope")
    @Expose
    private String scope;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("proj_ref")
    @Expose
    private String projRef;
    @SerializedName("proj_name")
    @Expose
    private String projName;
    @SerializedName("StatusName")
    @Expose
    private String statusName;
    @SerializedName("action_date")
    @Expose
    private String actionDate;
    @SerializedName("LastComment")
    @Expose
    private String lastComment;
    @SerializedName("next_followup_date")
    @Expose
    private String nextFollowupDate;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequuirementName() {
        return requuirementName;
    }

    public void setRequuirementName(String requuirementName) {
        this.requuirementName = requuirementName;
    }

    public String getPermitName() {
        return permitName;
    }

    public void setPermitName(String permitName) {
        this.permitName = permitName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjRef() {
        return projRef;
    }

    public void setProjRef(String projRef) {
        this.projRef = projRef;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getActionDate() {
        return actionDate;
    }

    public void setActionDate(String actionDate) {
        this.actionDate = actionDate;
    }

    public String getLastComment() {
        return lastComment;
    }

    public void setLastComment(String lastComment) {
        this.lastComment = lastComment;
    }

    public String getNextFollowupDate() {
        return nextFollowupDate;
    }

    public void setNextFollowupDate(String nextFollowupDate) {
        this.nextFollowupDate = nextFollowupDate;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

}
