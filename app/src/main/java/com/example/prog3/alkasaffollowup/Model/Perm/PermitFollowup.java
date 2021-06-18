
package com.example.prog3.alkasaffollowup.Model.Perm;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PermitFollowup {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("permit_id")
    @Expose
    private String permitId;
    @SerializedName("client_comments")
    @Expose
    private Object clientComments;
    @SerializedName("ProjectName")
    @Expose
    private String projectName;
    @SerializedName("PermitType")
    @Expose
    private String permitType;
    @SerializedName("Scope")
    @Expose
    private String scope;
    @SerializedName("Addreessee")
    @Expose
    private String addreessee;
    @SerializedName("proj_ref")
    @Expose
    private String projRef;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("permit_type_id")
    @Expose
    private Integer permitTypeId;
    @SerializedName("permit_scope_id")
    @Expose
    private Integer permitScopeId;
    @SerializedName("addressee_id")
    @Expose
    private Integer addresseeId;
    @SerializedName("contract_date")
    @Expose
    private String contractDate;
    @SerializedName("client_name")
    @Expose
    private String clientName;
    @SerializedName("progstart_date")
    @Expose
    private String progstartDate;
    @SerializedName("Last_Status")
    @Expose
    private Integer lastStatus;
    @SerializedName("Last_Status_Name")
    @Expose
    private String lastStatusName;
    @SerializedName("Last_Date")
    @Expose
    private String lastDate;
    @SerializedName("Location")
    @Expose
    private String location;
    @SerializedName("comment")
    @Expose
    private Object comment;
    @SerializedName("building_name")
    @Expose
    private String buildingName;
    @SerializedName("DurDays")
    @Expose
    private Integer durDays;

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

    public String getPermitId() {
        return permitId;
    }

    public void setPermitId(String permitId) {
        this.permitId = permitId;
    }

    public Object getClientComments() {
        return clientComments;
    }

    public void setClientComments(Object clientComments) {
        this.clientComments = clientComments;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPermitType() {
        return permitType;
    }

    public void setPermitType(String permitType) {
        this.permitType = permitType;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAddreessee() {
        return addreessee;
    }

    public void setAddreessee(String addreessee) {
        this.addreessee = addreessee;
    }

    public String getProjRef() {
        return projRef;
    }

    public void setProjRef(String projRef) {
        this.projRef = projRef;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Integer getPermitTypeId() {
        return permitTypeId;
    }

    public void setPermitTypeId(Integer permitTypeId) {
        this.permitTypeId = permitTypeId;
    }

    public Integer getPermitScopeId() {
        return permitScopeId;
    }

    public void setPermitScopeId(Integer permitScopeId) {
        this.permitScopeId = permitScopeId;
    }

    public Integer getAddresseeId() {
        return addresseeId;
    }

    public void setAddresseeId(Integer addresseeId) {
        this.addresseeId = addresseeId;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProgstartDate() {
        return progstartDate;
    }

    public void setProgstartDate(String progstartDate) {
        this.progstartDate = progstartDate;
    }

    public Integer getLastStatus() {
        return lastStatus;
    }

    public void setLastStatus(Integer lastStatus) {
        this.lastStatus = lastStatus;
    }

    public String getLastStatusName() {
        return lastStatusName;
    }

    public void setLastStatusName(String lastStatusName) {
        this.lastStatusName = lastStatusName;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getComment() {
        return comment;
    }

    public void setComment(Object comment) {
        this.comment = comment;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getDurDays() {
        return durDays;
    }

    public void setDurDays(Integer durDays) {
        this.durDays = durDays;
    }

}
