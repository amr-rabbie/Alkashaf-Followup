
package com.example.prog3.alkasaffollowup.Model.ProgStg;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjWorkscopeList {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("projects_permits")
    @Expose
    private List<Object> projectsPermits = null;
    @SerializedName("projects")
    @Expose
    private List<Project_> projects = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public List<Object> getProjectsPermits() {
        return projectsPermits;
    }

    public void setProjectsPermits(List<Object> projectsPermits) {
        this.projectsPermits = projectsPermits;
    }

    public List<Project_> getProjects() {
        return projects;
    }

    public void setProjects(List<Project_> projects) {
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
