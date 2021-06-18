
package com.example.prog3.alkasaffollowup.Model.ProjColl;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectCollected {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("payment_type_list")
    @Expose
    private Object paymentTypeList;
    @SerializedName("project_collecte_details")
    @Expose
    private List<Object> projectCollecteDetails = null;
    @SerializedName("project_invoices")
    @Expose
    private Object projectInvoices;
    @SerializedName("project")
    @Expose
    private Object project;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("invoice_number")
    @Expose
    private String invoiceNumber;
    @SerializedName("invoice_amount")
    @Expose
    private String invoiceAmount;
    @SerializedName("invoice_date")
    @Expose
    private String invoiceDate;
    @SerializedName("ChequeNo")
    @Expose
    private String chequeNo;
    @SerializedName("InvoiceID")
    @Expose
    private Integer invoiceID;
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
    @SerializedName("PaymentTypeID")
    @Expose
    private Object paymentTypeID;

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

    public List<Object> getProjectCollecteDetails() {
        return projectCollecteDetails;
    }

    public void setProjectCollecteDetails(List<Object> projectCollecteDetails) {
        this.projectCollecteDetails = projectCollecteDetails;
    }

    public Object getProjectInvoices() {
        return projectInvoices;
    }

    public void setProjectInvoices(Object projectInvoices) {
        this.projectInvoices = projectInvoices;
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

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public Integer getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(Integer invoiceID) {
        this.invoiceID = invoiceID;
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

    public Object getPaymentTypeID() {
        return paymentTypeID;
    }

    public void setPaymentTypeID(Object paymentTypeID) {
        this.paymentTypeID = paymentTypeID;
    }

}
