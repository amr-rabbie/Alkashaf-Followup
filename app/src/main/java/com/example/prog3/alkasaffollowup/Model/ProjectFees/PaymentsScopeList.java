
package com.example.prog3.alkasaffollowup.Model.ProjectFees;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentsScopeList {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("project_collecte_details")
    @Expose
    private List<Object> projectCollecteDetails = null;
    @SerializedName("project_fees")
    @Expose
    private List<ProjectFee_> projectFees = null;
    @SerializedName("project_invoice_details")
    @Expose
    private List<Object> projectInvoiceDetails = null;
    @SerializedName("project_payment_details")
    @Expose
    private List<Object> projectPaymentDetails = null;
    @SerializedName("projects_requirements")
    @Expose
    private List<Object> projectsRequirements = null;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("Name")
    @Expose
    private String name;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public List<Object> getProjectCollecteDetails() {
        return projectCollecteDetails;
    }

    public void setProjectCollecteDetails(List<Object> projectCollecteDetails) {
        this.projectCollecteDetails = projectCollecteDetails;
    }

    public List<ProjectFee_> getProjectFees() {
        return projectFees;
    }

    public void setProjectFees(List<ProjectFee_> projectFees) {
        this.projectFees = projectFees;
    }

    public List<Object> getProjectInvoiceDetails() {
        return projectInvoiceDetails;
    }

    public void setProjectInvoiceDetails(List<Object> projectInvoiceDetails) {
        this.projectInvoiceDetails = projectInvoiceDetails;
    }

    public List<Object> getProjectPaymentDetails() {
        return projectPaymentDetails;
    }

    public void setProjectPaymentDetails(List<Object> projectPaymentDetails) {
        this.projectPaymentDetails = projectPaymentDetails;
    }

    public List<Object> getProjectsRequirements() {
        return projectsRequirements;
    }

    public void setProjectsRequirements(List<Object> projectsRequirements) {
        this.projectsRequirements = projectsRequirements;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
