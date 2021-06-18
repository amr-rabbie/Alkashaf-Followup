package com.example.prog3.alkasaffollowup.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by prog3 on 3/10/2018.
 */

public class ClientsScreens implements Parcelable {
    int image;
    String name;

    public ClientsScreens() {
    }

    public ClientsScreens(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected ClientsScreens(Parcel in) {
        image = in.readInt();
        name = in.readString();
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeString(name);


    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ClientsScreens> CREATOR = new Creator<ClientsScreens>() {
        @Override
        public ClientsScreens createFromParcel(Parcel in) {
            return new ClientsScreens(in);
        }

        @Override
        public ClientsScreens[] newArray(int size) {
            return new ClientsScreens[size];
        }
    };
}
