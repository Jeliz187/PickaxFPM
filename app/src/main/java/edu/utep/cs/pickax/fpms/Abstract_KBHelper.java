package edu.utep.cs.pickax.fpms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class Abstract_KBHelper extends SQLiteOpenHelper {

    public Abstract_KBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //May be beneficial to have KBhelper superclass with actual imlpementation instead.
    //The following 2 methods are implemented the same in all classes that extend this class

    @Override
    public abstract void onCreate(SQLiteDatabase db);

    @Override
    public abstract void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);
}
