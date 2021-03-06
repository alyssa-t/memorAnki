package com.ple2020pi.memoranki;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OpenHelper extends SQLiteOpenHelper {

    //versao database
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MyDB.db";
    private static final String GROUP_TABLE_NAME = "mygrouptb";
    private static final String CARD_TABLE_NAME = "mycardtb";
    private static final String _ID = "_id";

    private static final String COLUMN_NAME_GROUP_NAME = "groupName";

    private static final String COLUMN_NAME_CARD_NAME = "cardName";
    private static final String COLUMN_NAME_CARD_READING = "cardReading";
    private static final String COLUMN_NAME_CARD_MEANING = "cardMeaning";
    private static final String COLUMN_NAME_CARD_TYPE = "cardType";
    private static final String COLUMN_NAME_CARD_GROUP = "cardGroup";
    private static final String COLUMN_NAME_CARD_REPETITION = "cardRepetition";
    private static final String COLUMN_NAME_CARD_LEARNING_RATE = "cardLR";
    private static final String COLUMN_NAME_CARD_LAST_DATE = "cardLD";


    private static final String SQL_CREATE_GROUP_ENTRIES =
            "CREATE TABLE " + GROUP_TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_GROUP_NAME + " TEXT)";

    private static final String SQL_CREATE_CARD_ENTRIES =
            "CREATE TABLE " + CARD_TABLE_NAME + " (" +
                    _ID + " INTEGER PRIMARY KEY," +
                    COLUMN_NAME_CARD_NAME + " TEXT," +
                    COLUMN_NAME_CARD_READING + " TEXT," +
                    COLUMN_NAME_CARD_MEANING + " TEXT," +
                    COLUMN_NAME_CARD_TYPE + " TEXT," +
                    COLUMN_NAME_CARD_GROUP + " INTEGER," +
                    COLUMN_NAME_CARD_REPETITION + " INTEGER," +
                    COLUMN_NAME_CARD_LEARNING_RATE + " REAL," +
                    COLUMN_NAME_CARD_LAST_DATE + " TEXT)";

    private static final String SQL_DELETE_GROUP_ENTRIES =
            "DROP TABLE IF EXISTS " + GROUP_TABLE_NAME;

    private static final String SQL_DELETE_CARD_ENTRIES =
            "DROP TABLE IF EXISTS " + CARD_TABLE_NAME;

    public OpenHelper(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION);}

    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(
                SQL_CREATE_GROUP_ENTRIES
        );
        db.execSQL(
                SQL_CREATE_CARD_ENTRIES
        );
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersdion, int newVersion) {
        db.execSQL(
                SQL_DELETE_GROUP_ENTRIES
        );
        db.execSQL(
                SQL_DELETE_CARD_ENTRIES
        );
        onCreate(db);
    }

    public void onDowngrade (SQLiteDatabase db, int oldVersdion, int newVersion) {
        onUpgrade(db, oldVersdion,newVersion);
    }

}
