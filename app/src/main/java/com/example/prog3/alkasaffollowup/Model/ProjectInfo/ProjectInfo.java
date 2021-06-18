
package com.example.prog3.alkasaffollowup.Model.ProjectInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectInfo {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("client")
    @Expose
    private Object client;
    @SerializedName("proj_status_list")
    @Expose
    private ProjStatusList projStatusList;
    @SerializedName("proj_types_list")
    @Expose
    private ProjTypesList projTypesList;
    @SerializedName("proj_workscope_list")
    @Expose
    private ProjWorkscopeList projWorkscopeList;
    @SerializedName("project_category_list")
    @Expose
    private ProjectCategoryList projectCategoryList;
    @SerializedName("project_collectes")
    @Expose
    private List<Object> projectCollectes = null;
    @SerializedName("project_fees")
    @Expose
    private List<Object> projectFees = null;
    @SerializedName("project_invoices")
    @Expose
    private List<Object> projectInvoices = null;
    @SerializedName("project_payment_config")
    @Expose
    private List<Object> projectPaymentConfig = null;
    @SerializedName("project_payments")
    @Expose
    private List<Object> projectPayments = null;
    @SerializedName("project_usage_list")
    @Expose
    private ProjectUsageList projectUsageList;
    @SerializedName("project_visits")
    @Expose
    private List<Object> projectVisits = null;
    @SerializedName("project_visits_contract")
    @Expose
    private List<Object> projectVisitsContract = null;
    @SerializedName("projects_conditions")
    @Expose
    private List<Object> projectsConditions = null;
    @SerializedName("projects_fees")
    @Expose
    private Object projectsFees;
    @SerializedName("projects_permits")
    @Expose
    private List<Object> projectsPermits = null;
    @SerializedName("qat_cities_list")
    @Expose
    private QatCitiesList qatCitiesList;
    @SerializedName("projects_requirements")
    @Expose
    private List<Object> projectsRequirements = null;
    @SerializedName("projects_schedule")
    @Expose
    private Object projectsSchedule;
    @SerializedName("sn")
    @Expose
    private Integer sn;
    @SerializedName("proj_client_id")
    @Expose
    private Integer projClientId;
    @SerializedName("proj_name")
    @Expose
    private String projName;
    @SerializedName("proj_ref")
    @Expose
    private String projRef;
    @SerializedName("building_name")
    @Expose
    private String buildingName;
    @SerializedName("proj_area")
    @Expose
    private String projArea;
    @SerializedName("proj_floors")
    @Expose
    private Object projFloors;
    @SerializedName("discplns_list")
    @Expose
    private String discplnsList;
    @SerializedName("progress_stage")
    @Expose
    private String progressStage;
    @SerializedName("proj_deliverable")
    @Expose
    private String projDeliverable;
    @SerializedName("dpme_projid")
    @Expose
    private Integer dpmeProjid;
    @SerializedName("location_id")
    @Expose
    private Integer locationId;
    @SerializedName("usag_id")
    @Expose
    private Integer usagId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("type_id")
    @Expose
    private Integer typeId;
    @SerializedName("scope_id")
    @Expose
    private Integer scopeId;
    @SerializedName("status_id")
    @Expose
    private Integer statusId;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

    public ProjStatusList getProjStatusList() {
        return projStatusList;
    }

    public void setProjStatusList(ProjStatusList projStatusList) {
        this.projStatusList = projStatusList;
    }

    public ProjTypesList getProjTypesList() {
        return projTypesList;
    }

    public void setProjTypesList(ProjTypesList projTypesList) {
        this.projTypesList = projTypesList;
    }

    public ProjWorkscopeList getProjWorkscopeList() {
        return projWorkscopeList;
    }

    public void setProjWorkscopeList(ProjWorkscopeList projWorkscopeList) {
        this.projWorkscopeList = projWorkscopeList;
    }

    public ProjectCategoryList getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(ProjectCategoryList projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
    }

    public List<Object> getProjectCollectes() {
        return projectCollectes;
    }

    public void setProjectCollectes(List<Object> projectCollectes) {
        this.projectCollectes = projectCollectes;
    }

    public List<Object> getProjectFees() {
        return projectFees;
    }

    public void setProjectFees(List<Object> projectFees) {
        this.projectFees = projectFees;
    }

    public List<Object> getProjectInvoices() {
        return projectInvoices;
    }

    public void setProjectInvoices(List<Object> projectInvoices) {
        this.projectInvoices = projectInvoices;
    }

    public List<Object> getProjectPaymentConfig() {
        return projectPaymentConfig;
    }

    public void setProjectPaymentConfig(List<Object> projectPaymentConfig) {
        this.projectPaymentConfig = projectPaymentConfig;
    }

    public List<Object> getProjectPayments() {
        return projectPayments;
    }

    public void setProjectPayments(List<Object> projectPayments) {
        this.projectPayments = projectPayments;
    }

    public ProjectUsageList getProjectUsageList() {
        return projectUsageList;
    }

    public void setProjectUsageList(ProjectUsageList projectUsageList) {
        this.projectUsageList = projectUsageList;
    }

    public List<Object> getProjectVisits() {
        return projectVisits;
    }

    public void setProjectVisits(List<Object> projectVisits) {
        this.projectVisits = projectVisits;
    }

    public List<Object> getProjectVisitsContract() {
        return projectVisitsContract;
    }

    public void setProjectVisitsContract(List<Object> projectVisitsContract) {
        this.projectVisitsContract = projectVisitsContract;
    }

    public List<Object> getProjectsConditions() {
        return projectsConditions;
    }

    public void setProjectsConditions(List<Object> projectsConditions) {
        this.projectsConditions = projectsConditions;
    }

    public Object getProjectsFees() {
        return projectsFees;
    }

    public void setProjectsFees(Object projectsFees) {
        this.projectsFees = projectsFees;
    }

    public List<Object> getProjectsPermits() {
        return projectsPermits;
    }

    public void setProjectsPermits(List<Object> projectsPermits) {
        this.projectsPermits = projectsPermits;
    }

    public QatCitiesList getQatCitiesList() {
        return qatCitiesList;
    }

    public void setQatCitiesList(QatCitiesList qatCitiesList) {
        this.qatCitiesList = qatCitiesList;
    }

    public List<Object> getProjectsRequirements() {
        return projectsRequirements;
    }

    public void setProjectsRequirements(List<Object> projectsRequirements) {
        this.projectsRequirements = projectsRequirements;
    }

    public Object getProjectsSchedule() {
        return projectsSchedule;
    }

    public void setProjectsSchedule(Object projectsSchedule) {
        this.projectsSchedule = projectsSchedule;
    }

    public Integer getSn() {
        return sn;
    }

    public void setSn(Integer sn) {
        this.sn = sn;
    }

    public Integer getProjClientId() {
        return projClientId;
    }

    public void setProjClientId(Integer projClientId) {
        this.projClientId = projClientId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjRef() {
        return projRef;
    }

    public void setProjRef(String projRef) {
        this.projRef = projRef;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getProjArea() {
        return projArea;
    }

    public void setProjArea(String projArea) {
        this.projArea = projArea;
    }

    public Object getProjFloors() {
        return projFloors;
    }

    public void setProjFloors(Object projFloors) {
        this.projFloors = projFloors;
    }

    public String getDiscplnsList() {
        return discplnsList;
    }

    public void setDiscplnsList(String discplnsList) {
        this.discplnsList = discplnsList;
    }

    public String getProgressStage() {
        return progressStage;
    }

    public void setProgressStage(String progressStage) {
        this.progressStage = progressStage;
    }

    public String getProjDeliverable() {
        return projDeliverable;
    }

    public void setProjDeliverable(String projDeliverable) {
        this.projDeliverable = projDeliverable;
    }

    public Integer getDpmeProjid() {
        return dpmeProjid;
    }

    public void setDpmeProjid(Integer dpmeProjid) {
        this.dpmeProjid = dpmeProjid;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getUsagId() {
        return usagId;
    }

    public void setUsagId(Integer usagId) {
        this.usagId = usagId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getScopeId() {
        return scopeId;
    }

    public void setScopeId(Integer scopeId) {
        this.scopeId = scopeId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

}
