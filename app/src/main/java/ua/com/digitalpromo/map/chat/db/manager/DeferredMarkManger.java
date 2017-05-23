package ua.com.digitalpromo.map.chat.db.manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ua.com.digitalpromo.map.chat.db.DB;
import ua.com.digitalpromo.map.chat.db.DBHelper;

/**
 * Created by ales_san on 9/5/14.
 */
public class DeferredMarkManger {

    private static DeferredMarkManger deferredMarkManger;
    private final DBHelper dbHelper;
    private final SQLiteDatabase writableDatabase;

    private DeferredMarkManger(Context context) {
        super();
        dbHelper = new DBHelper(context);
        writableDatabase = dbHelper.getWritableDatabase();
    }

    public static DeferredMarkManger getInstance(Context context) {
        if (deferredMarkManger == null) deferredMarkManger = new DeferredMarkManger(context);
        return deferredMarkManger;
    }

    public void insert(DeferredMark deferredMark) {
        ContentValues contentValues = DeferredMark.getContentValues(deferredMark);
        writableDatabase.insert(DB.deferred_mark.name(), null, contentValues);
    }

    public Cursor getAll() {
        Cursor cursor = writableDatabase.query(DB.deferred_mark.name(),
                DB.deferred_mark.getNameArray(),
                null, null, null, null, null, null);
        return cursor;
    }

    public int delete(int id) {
        String where = DB.DeferredMark._id.name() + "=" + id;
        int row = writableDatabase.delete(DB.deferred_mark.name(), where, null);
        return row;
    }
}
