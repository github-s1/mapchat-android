package ua.com.digitalpromo.map.chat.db;

/**
 * Created by ales_san on 9/5/14.
 */
public enum DB {
    deferred_mark;

    public String[] getNameArray() {
        Enum[] values = new Enum[0];
        switch (this) {
            case deferred_mark:
                values = DeferredMark.values();
                break;
        }
        int length = values.length;
        String[] strings = new String[length];
        for (int i = 0; i < length; i++) {
            strings[i] = values[i].name();
        }
        return strings;
    }

    public enum DeferredMark {
        _id,
        description,
        address,
        date
    }
}
