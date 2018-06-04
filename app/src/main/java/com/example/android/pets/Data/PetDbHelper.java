package com.example.android.pets.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {
    public static final String TAG = "PetDbHelper";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " +
                PetsContract.PetsEntry.TABLE_NAME + "( " +
                PetsContract.PetsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetsContract.PetsEntry.COLUMN_PET_NAME + " TEXT NOT NULL, " +
                PetsContract.PetsEntry.COLUMN_PET_BREED + " TEXT, " +
                PetsContract.PetsEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL , " +
                PetsContract.PetsEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0 );";

        sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String SQL_DELETE_OLD_TABLE = "DROP TABLE IF EXISTS " +
                PetsContract.PetsEntry.TABLE_NAME;
        sqLiteDatabase.execSQL(SQL_DELETE_OLD_TABLE);
        onCreate(sqLiteDatabase);
    }
}
