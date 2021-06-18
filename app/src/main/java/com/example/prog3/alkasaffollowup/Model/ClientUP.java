
package com.example.prog3.alkasaffollowup.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClientUP {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("client_username")
    @Expose
    private String clientUsername;
    @SerializedName("client_password")
    @Expose
    private String clientPassword;
    @SerializedName("client_id")
    @Expose
    private int clientId;
    @SerializedName("group_id")
    @Expose
    private Integer groupId;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("employee_id")
    @Expose
    private int employeeId;
    @SerializedName("client")
    @Expose
    private Object client;
    @SerializedName("notifies")
    @Expose
    private List<Object> notifies = null;
    @SerializedName("notifies1")
    @Expose
    private List<Object> notifies1 = null;
    @SerializedName("sec_users_groups_rel")
    @Expose
    private List<Object> secUsersGroupsRel = null;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Object getClient() {
        return client;
    }

    public void setClient(Object client) {
        this.client = client;
    }

    public List<Object> getNotifies() {
        return notifies;
    }

    public void setNotifies(List<Object> notifies) {
        this.notifies = notifies;
    }

    public List<Object> getNotifies1() {
        return notifies1;
    }

    public void setNotifies1(List<Object> notifies1) {
        this.notifies1 = notifies1;
    }

    public List<Object> getSecUsersGroupsRel() {
        return secUsersGroupsRel;
    }

    public void setSecUsersGroupsRel(List<Object> secUsersGroupsRel) {
        this.secUsersGroupsRel = secUsersGroupsRel;
    }

}
