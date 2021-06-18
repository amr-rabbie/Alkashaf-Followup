
package com.example.prog3.alkasaffollowup.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectCondition {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("project_category_list")
    @Expose
    private Object projectCategoryList;
    @SerializedName("project")
    @Expose
    private Object project;
    @SerializedName("SN")
    @Expose
    private Integer sN;
    @SerializedName("condition_category")
    @Expose
    private String conditionCategory;
    @SerializedName("proj_condition")
    @Expose
    private String projCondition;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Object getProjectCategoryList() {
        return projectCategoryList;
    }

    public void setProjectCategoryList(Object projectCategoryList) {
        this.projectCategoryList = projectCategoryList;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public Integer getSN() {
        return sN;
    }

    public void setSN(Integer sN) {
        this.sN = sN;
    }

    public String getConditionCategory() {
        return conditionCategory;
    }

    public void setConditionCategory(String conditionCategory) {
        this.conditionCategory = conditionCategory;
    }

    public String getProjCondition() {
        return projCondition;
    }

    public void setProjCondition(String projCondition) {
        this.projCondition = projCondition;
    }

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

}
