
package com.example.prog3.alkasaffollowup.Model.ProjInvoi;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectInvoice {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("payment_type_list")
    @Expose
    private Object paymentTypeList;
    @SerializedName("project_collectes")
    @Expose
    private List<Object> projectCollectes = null;
    @SerializedName("project_invoice_details")
    @Expose
    private List<Object> projectInvoiceDetails = null;
    @SerializedName("project_payments")
    @Expose
    private Object projectPayments;
    @SerializedName("project")
    @Expose
    private String project;
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
    @SerializedName("method_id")
    @Expose
    private Integer methodId;
    @SerializedName("PaymentID")
    @Expose
    private Integer paymentID;
    @SerializedName("CreatedAt")
    @Expose
    private Object createdAt;
    @SerializedName("CreatedBy")
    @Expose
    private Object createdBy;
    @SerializedName("UpdatedAt")
    @Expose
    private String updatedAt;
    @SerializedName("UpdatedBy")
    @Expose
    private Integer updatedBy;
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

    public Object getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(Object paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    public List<Object> getProjectCollectes() {
        return projectCollectes;
    }

    public void setProjectCollectes(List<Object> projectCollectes) {
        this.projectCollectes = projectCollectes;
    }

    public List<Object> getProjectInvoiceDetails() {
        return projectInvoiceDetails;
    }

    public void setProjectInvoiceDetails(List<Object> projectInvoiceDetails) {
        this.projectInvoiceDetails = projectInvoiceDetails;
    }

    public Object getProjectPayments() {
        return projectPayments;
    }

    public void setProjectPayments(Object projectPayments) {
        this.projectPayments = projectPayments;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
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

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
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
