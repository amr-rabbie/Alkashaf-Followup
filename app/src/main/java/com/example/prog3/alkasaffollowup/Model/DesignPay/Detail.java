
package com.example.prog3.alkasaffollowup.Model.DesignPay;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Detail {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("Scope")
    @Expose
    private String scope;
    @SerializedName("Perc")
    @Expose
    private Integer perc;
    @SerializedName("Value")
    @Expose
    private Object value;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getPerc() {
        return perc;
    }

    public void setPerc(Integer perc) {
        this.perc = perc;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
