
package com.example.prog3.alkasaffollowup.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesignPayement {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("payment_type_list")
    @Expose
    private Object paymentTypeList;
    @SerializedName("project_invoices")
    @Expose
    private List<Object> projectInvoices = null;
    @SerializedName("project_payment_config")
    @Expose
    private Object projectPaymentConfig;
    @SerializedName("project_payment_details")
    @Expose
    private List<Object> projectPaymentDetails = null;
    @SerializedName("project")
    @Expose
    private Object project;
    @SerializedName("project_visits")
    @Expose
    private List<Object> projectVisits = null;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("PaymentTypeID")
    @Expose
    private Integer paymentTypeID;
    @SerializedName("PaymentIndex")
    @Expose
    private Integer paymentIndex;
    @SerializedName("Perc")
    @Expose
    private Integer perc;
    @SerializedName("Value")
    @Expose
    private Object value;
    @SerializedName("DueAt")
    @Expose
    private Object dueAt;
    @SerializedName("Conditions")
    @Expose
    private Object conditions;
    @SerializedName("Notes")
    @Expose
    private String notes;
    @SerializedName("CreatedAt")
    @Expose
    private Object createdAt;
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
    @SerializedName("ConditionTypeID")
    @Expose
    private Object conditionTypeID;
    @SerializedName("PaymentConfigID")
    @Expose
    private Object paymentConfigID;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Object getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(Object paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<Object> getProjectInvoices() {
        return projectInvoices;
    }

    public void setProjectInvoices(List<Object> projectInvoices) {
        this.projectInvoices = projectInvoices;
    }

    public Object getProjectPaymentConfig() {
        return projectPaymentConfig;
    }

    public void setProjectPaymentConfig(Object projectPaymentConfig) {
        this.projectPaymentConfig = projectPaymentConfig;
    }

    public List<Object> getProjectPaymentDetails() {
        return projectPaymentDetails;
    }

    public void setProjectPaymentDetails(List<Object> projectPaymentDetails) {
        this.projectPaymentDetails = projectPaymentDetails;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public List<Object> getProjectVisits() {
        return projectVisits;
    }

    public void setProjectVisits(List<Object> projectVisits) {
        this.projectVisits = projectVisits;
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

    public Integer getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(Integer paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

    public Integer getPaymentIndex() {
        return paymentIndex;
    }

    public void setPaymentIndex(Integer paymentIndex) {
        this.paymentIndex = paymentIndex;
    }

    public Integer getPerc() {
        return perc;
    }

    public void setPerc(Integer perc) {
        this.perc = perc;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getDueAt() {
        return dueAt;
    }

    public void setDueAt(Object dueAt) {
        this.dueAt = dueAt;
    }

    public Object getConditions() {
        return conditions;
    }

    public void setConditions(Object conditions) {
        this.conditions = conditions;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
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

    public Object getConditionTypeID() {
        return conditionTypeID;
    }

    public void setConditionTypeID(Object conditionTypeID) {
        this.conditionTypeID = conditionTypeID;
    }

    public Object getPaymentConfigID() {
        return paymentConfigID;
    }

    public void setPaymentConfigID(Object paymentConfigID) {
        this.paymentConfigID = paymentConfigID;
    }

}
