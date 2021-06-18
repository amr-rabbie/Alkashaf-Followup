
package com.example.prog3.alkasaffollowup.Model.DesignPay;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesignPayement {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("PaymentID")
    @Expose
    private Integer paymentID;
    @SerializedName("PaymentType")
    @Expose
    private String paymentType;
    @SerializedName("PaymentIndex")
    @Expose
    private Integer paymentIndex;
    @SerializedName("DueAt")
    @Expose
    private Object dueAt;
    @SerializedName("Notes")
    @Expose
    private String notes;
    @SerializedName("Details")
    @Expose
    private List<Detail> details = null;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(Integer paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPaymentIndex() {
        return paymentIndex;
    }

    public void setPaymentIndex(Integer paymentIndex) {
        this.paymentIndex = paymentIndex;
    }

    public Object getDueAt() {
        return dueAt;
    }

    public void setDueAt(Object dueAt) {
        this.dueAt = dueAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

}
