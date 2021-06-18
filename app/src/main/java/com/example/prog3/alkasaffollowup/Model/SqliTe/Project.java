package com.example.prog3.alkasaffollowup.Model.SqliTe;

import android.os.Parcel;
import android.os.Parcelable;

public class Project implements Parcelable {

    String projname;
    String Projref;
    int sn;

    public Project(String projname, String projref, int sn) {
        this.projname = projname;
        Projref = projref;
        this.sn = sn;
    }

    public String getProjname() {
        return projname;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public String getProjref() {
        return Projref;
    }

    public void setProjref(String projref) {
        Projref = projref;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    protected Project(Parcel in) {
        sn = in.readInt();
        projname = in.readString();
        Projref = in.readString();

    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(sn);
        dest.writeString(projname);
        dest.writeString(Projref);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Project> CREATOR = new Parcelable.Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };
}
