package ua.com.digitalpromo.map.chat.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ales_san on 9/5/14.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String STRING = "STRING";
    public static final String AUTOINCREMENT = "AUTOINCREMENT";
    public static final String NOT_NULL = "NOT NULL";
    public static final String PRIMARY_KEY = "PRIMARY KEY";
    public static final String CREATE_TABLE = "CREATE TABLE";
    public static final String UNIQUE = "UNIQUE";
    private static final String INTEGER = "INTEGER";
    private static final String DB_NAME = "custom search";
    private static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        createAudioTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void createAudioTable(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE + " " + DB.deferred_mark + "(" +
                        DB.DeferredMark._id + " " + INTEGER + " " + PRIMARY_KEY + " " + AUTOINCREMENT + "," +
                        DB.DeferredMark.description + " " + STRING + " " + "," +
                        DB.DeferredMark.address + " " + STRING + " " + "," +
                        DB.DeferredMark.date + " " + INTEGER + " " + NOT_NULL +
                        ");"
        );
    }
}
