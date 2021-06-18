
package com.example.prog3.alkasaffollowup.Model.ProjectInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectUsageList {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("projects")
    @Expose
    private List<Project____> projects = null;
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

    public List<Project____> getProjects() {
        return projects;
    }

    public void setProjects(List<Project____> projects) {
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
