
package com.example.prog3.alkasaffollowup.Model.ScdualeFollup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchdualeFollowUp {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("project")
    @Expose
    private String project;
    @SerializedName("contract_date")
    @Expose
    private String contractDate;
    @SerializedName("cont_Expctd_date")
    @Expose
    private String contExpctdDate;
    @SerializedName("Sup_Expctd_date")
    @Expose
    private Object supExpctdDate;
    @SerializedName("document_recv_date")
    @Expose
    private String documentRecvDate;
    @SerializedName("down_recv_date")
    @Expose
    private String downRecvDate;
    @SerializedName("progstart_date")
    @Expose
    private String progstartDate;
    @SerializedName("planed_date")
    @Expose
    private String planedDate;
    @SerializedName("actual_finish_date")
    @Expose
    private String actualFinishDate;
    @SerializedName("dev_days")
    @Expose
    private Integer devDays;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("ExpectedDesignDuration")
    @Expose
    private Object expectedDesignDuration;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContExpctdDate() {
        return contExpctdDate;
    }

    public void setContExpctdDate(String contExpctdDate) {
        this.contExpctdDate = contExpctdDate;
    }

    public Object getSupExpctdDate() {
        return supExpctdDate;
    }

    public void setSupExpctdDate(Object supExpctdDate) {
        this.supExpctdDate = supExpctdDate;
    }

    public String getDocumentRecvDate() {
        return documentRecvDate;
    }

    public void setDocumentRecvDate(String documentRecvDate) {
        this.documentRecvDate = documentRecvDate;
    }

    public String getDownRecvDate() {
        return downRecvDate;
    }

    public void setDownRecvDate(String downRecvDate) {
        this.downRecvDate = downRecvDate;
    }

    public String getProgstartDate() {
        return progstartDate;
    }

    public void setProgstartDate(String progstartDate) {
        this.progstartDate = progstartDate;
    }

    public String getPlanedDate() {
        return planedDate;
    }

    public void setPlanedDate(String planedDate) {
        this.planedDate = planedDate;
    }

    public String getActualFinishDate() {
        return actualFinishDate;
    }

    public void setActualFinishDate(String actualFinishDate) {
        this.actualFinishDate = actualFinishDate;
    }

    public Integer getDevDays() {
        return devDays;
    }

    public void setDevDays(Integer devDays) {
        this.devDays = devDays;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Object getExpectedDesignDuration() {
        return expectedDesignDuration;
    }

    public void setExpectedDesignDuration(Object expectedDesignDuration) {
        this.expectedDesignDuration = expectedDesignDuration;
    }

}
