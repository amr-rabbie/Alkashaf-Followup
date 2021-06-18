
package com.example.prog3.alkasaffollowup.Model.ProjectInfo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjTypesList {

    @SerializedName("$id")
    @Expose
    private String $id;
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
