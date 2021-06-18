package com.example.prog3.alkasaffollowup.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by prog5 on 3/26/2018.
 */

public class MailingOut implements Parcelable{
    public MailingOut(String $id, Integer iD, Integer projectID,
                      String subject, String purpose, Integer state,
                      String fromPerson, String fromCompany, Object projectName,
                      Integer isEmployee, String toDivision, String toEmployee,
                      String toBranch, Integer fromCompanyID, Integer fromPersonID,
                      String sentDate) {
        this.$id = $id;
        this.iD = iD;
        this.projectID = projectID;
        this.subject = subject;
        this.purpose = purpose;
        this.state = state;
        this.fromPerson = fromPerson;
        this.fromCompany = fromCompany;
        this.projectName = (String) projectName;
        this.isEmployee = isEmployee;
        this.toDivision = toDivision;
        this.toEmployee = toEmployee;
        this.toBranch = toBranch;
        this.fromCompanyID = fromCompanyID;
        this.fromPersonID = fromPersonID;
        this.sentDate = sentDate;

    }

    protected MailingOut(Parcel in){
        $id=in.readString();
        iD=in.readInt();
        projectID=in.readInt();
        subject=in.readString();
        purpose=in.readString();
        state=in.readInt();
        fromPerson=in.readString();
        fromCompany=in.readString();
        projectName=in.readString();
        isEmployee=in.readInt();
        toDivision=in.readString();
        toEmployee=in.readString();
        toBranch=in.readString();
        fromCompanyID=in.readInt();
        fromPersonID=in.readInt();
        sentDate=in.readString();
    }

    public String getsProjectName() {
        return sProjectName;
    }

    public void setsProjectName(String sProjectName) {
        this.sProjectName = sProjectName;
    }

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("ID")
    @Expose
    private Integer iD;
    @SerializedName("ProjectID")
    @Expose
    private Integer projectID;
    @SerializedName("Subject")
    @Expose
    private String subject;
    @SerializedName("Purpose")
    @Expose
    private String purpose;
    @SerializedName("State")
    @Expose
    private Integer state;
    @SerializedName("FromPerson")
    @Expose
    private String fromPerson;
    @SerializedName("FromCompany")
    @Expose
    private String fromCompany;
    @SerializedName("ProjectName")
    @Expose
    private String projectName;
    @SerializedName("IsEmployee")
    @Expose
    private Integer isEmployee;
    @SerializedName("ToDivision")
    @Expose
    private String toDivision;
    @SerializedName("ToEmployee")
    @Expose
    private String toEmployee;
    @SerializedName("ToBranch")
    @Expose
    private String toBranch;
    @SerializedName("FromCompanyID")
    @Expose
    private Integer fromCompanyID;
    @SerializedName("FromPersonID")
    @Expose
    private Integer fromPersonID;
    @SerializedName("SentDate")
    @Expose
    private String sentDate;

    private String sProjectName;

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public Integer getID() {
        return iD;
    }

    public void setID(Integer iD) {
        this.iD = iD;
    }

    public Integer getProjectID() {
        return projectID;
    }

    public void setProjectID(Integer projectID) {
        this.projectID = projectID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(String fromPerson) {
        this.fromPerson = fromPerson;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName =  projectName;
    }

    public Integer getIsEmployee() {
        return isEmployee;
    }

    public void setIsEmployee(Integer isEmployee) {
        this.isEmployee = isEmployee;
    }

    public String getToDivision() {
        return toDivision;
    }

    public void setToDivision(String toDivision) {
        this.toDivision = toDivision;
    }

    public String getToEmployee() {
        return toEmployee;
    }

    public void setToEmployee(String toEmployee) {
        this.toEmployee = toEmployee;
    }

    public String getToBranch() {
        return toBranch;
    }

    public void setToBranch(String toBranch) {
        this.toBranch = toBranch;
    }

    public Integer getFromCompanyID() {
        return fromCompanyID;
    }

    public void setFromCompanyID(Integer fromCompanyID) {
        this.fromCompanyID = fromCompanyID;
    }

    public Integer getFromPersonID() {
        return fromPersonID;
    }

    public void setFromPersonID(Integer fromPersonID) {
        this.fromPersonID = fromPersonID;
    }

    public String getSentDate() {
        return sentDate;
    }

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MailingOut> CREATOR = new Creator<MailingOut>() {
        @Override
        public MailingOut createFromParcel(Parcel parcel) {
            return new MailingOut(parcel);
        }

        @Override
        public MailingOut[] newArray(int i) {
            return new MailingOut[i];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString($id);
        parcel.writeInt(iD);
        parcel.writeInt(projectID);
        parcel.writeString(subject);
        parcel.writeString(purpose);
        parcel.writeInt(state);
        parcel.writeString(fromPerson);
        parcel.writeString(fromCompany);
        parcel.writeString(projectName);
        parcel.writeInt(isEmployee);
        parcel.writeString(toDivision);
        parcel.writeString(toEmployee);
        parcel.writeString(toBranch);
        parcel.writeInt(fromCompanyID);
        parcel.writeInt(fromPersonID);
        parcel.writeString(sentDate);


    }
}

