
package com.example.prog3.alkasaffollowup.Model.ProjectInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectCategoryList {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("projects_conditions")
    @Expose
    private List<Object> projectsConditions = null;
    @SerializedName("projects")
    @Expose
    private List<Project___> projects = null;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public List<Object> getProjectsConditions() {
        return projectsConditions;
    }

    public void setProjectsConditions(List<Object> projectsConditions) {
        this.projectsConditions = projectsConditions;
    }

    public List<Project___> getProjects() {
        return projects;
    }

    public void setProjects(List<Project___> projects) {
        this.projects = projects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
