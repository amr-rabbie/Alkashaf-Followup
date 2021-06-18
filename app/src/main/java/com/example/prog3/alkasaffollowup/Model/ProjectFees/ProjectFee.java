
package com.example.prog3.alkasaffollowup.Model.ProjectFees;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectFee {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("Payments_Scope_list")
    @Expose
    private PaymentsScopeList paymentsScopeList;
    @SerializedName("project")
    @Expose
    private Object project;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("ScopeID")
    @Expose
    private Integer scopeID;
    @SerializedName("Value")
    @Expose
    private Integer value;
    @SerializedName("CreatedAt")
    @Expose
    private String createdAt;
    @SerializedName("CreatedBy")
    @Expose
    private Object createdBy;
    @SerializedName("UpdatedAt")
    @Expose
    private Object updatedAt;
    @SerializedName("UpdatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("ApprovedAt")
    @Expose
    private Object approvedAt;
    @SerializedName("ApprovedBy")
    @Expose
    private Object approvedBy;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public PaymentsScopeList getPaymentsScopeList() {
        return paymentsScopeList;
    }

    public void setPaymentsScopeList(PaymentsScopeList paymentsScopeList) {
        this.paymentsScopeList = paymentsScopeList;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Integer getScopeID() {
        return scopeID;
    }

    public void setScopeID(Integer scopeID) {
        this.scopeID = scopeID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Object createdBy) {
        this.createdBy = createdBy;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Object getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Object approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Object getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Object approvedBy) {
        this.approvedBy = approvedBy;
    }

}
