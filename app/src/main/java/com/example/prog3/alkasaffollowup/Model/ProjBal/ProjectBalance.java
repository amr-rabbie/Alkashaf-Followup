
package com.example.prog3.alkasaffollowup.Model.ProjBal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectBalance  {

    @SerializedName("client_name")
    @Expose
    private String clientName;
    @SerializedName("proj_name")
    @Expose
    private String projName;
    @SerializedName("proj_ref")
    @Expose
    private String projRef;
    @SerializedName("proj_id")
    @Expose
    private Integer projId;
    @SerializedName("ScopeID")
    @Expose
    private Integer scopeID;
    @SerializedName("scope")
    @Expose
    private String scope;
    @SerializedName("Value")
    @Expose
    private Integer value;
    @SerializedName("Invoices")
    @Expose
    private Integer invoices;
    @SerializedName("collected")
    @Expose
    private Integer collected;
    @SerializedName("Balance")
    @Expose
    private Integer balance;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public Integer getScopeID() {
        return scopeID;
    }

    public void setScopeID(Integer scopeID) {
        this.scopeID = scopeID;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getInvoices() {
        return invoices;
    }

    public void setInvoices(Integer invoices) {
        this.invoices = invoices;
    }

    public Integer getCollected() {
        return collected;
    }

    public void setCollected(Integer collected) {
        this.collected = collected;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }


}
