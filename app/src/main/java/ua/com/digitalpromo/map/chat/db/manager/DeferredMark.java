package ua.com.digitalpromo.map.chat.db.manager;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Calendar;

import ua.com.digitalpromo.map.chat.db.DB;

/**
 * Created by ales_san on 10/13/14.
 */
public class DeferredMark {
    public int id;
    /**
     * описание вида.
     */
    public String description;
    /**
     * address mark.
     */
    public String address;

    public Calendar date;

    public static ContentValues getContentValues(DeferredMark deferredMark) {
        ContentValues contentValues = new ContentValues();
        if (deferredMark.description != null)
            contentValues.put(DB.DeferredMark.description.name(), deferredMark.description);
        if (deferredMark.address != null)
            contentValues.put(DB.DeferredMark.address.name(), deferredMark.address);
        if (deferredMark.date != null)
            contentValues.put(DB.DeferredMark.date.name(), deferredMark.date.getTimeInMillis());

        return contentValues;
    }

    public static DeferredMark getItemSearch(Cursor cursor) {
        DeferredMark deferredMark = new DeferredMark();
        deferredMark.id = cursor.getInt(DB.DeferredMark._id.ordinal());
        deferredMark.description = cursor.getString(DB.DeferredMark.description.ordinal());
        deferredMark.address = cursor.getString(DB.DeferredMark.address.ordinal());
        deferredMark.date = Calendar.getInstance();
        deferredMark.date.setTimeInMillis(cursor.getLong(DB.DeferredMark.date.ordinal()));

        return deferredMark;
    }
}
