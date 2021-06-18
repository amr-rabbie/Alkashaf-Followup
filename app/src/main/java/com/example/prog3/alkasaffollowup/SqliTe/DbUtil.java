package com.example.prog3.alkasaffollowup.SqliTe;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbUtil extends SQLiteOpenHelper {
    public DbUtil(Context context) {
        super(context, Data.Db_Name, null, Data.Db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table "+Data.Db_Table+" ( "+
                Data.Key_ProjName+" text , "+Data.Key_ProjRef+" text , "+
                Data.Key_Sn+" text  ) ";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="drop table "+Data.Db_Table;
        db.execSQL(sql);
        onCreate(db);

    }
}
