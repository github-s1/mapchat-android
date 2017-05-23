package ua.com.digitalpromo.map.chat.util;

import android.content.Context;
import android.text.format.DateFormat;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

import ua.com.digitalpromo.map.chat.App;
import ua.com.digitalpromo.map.chat.R;

/**
 * Created by android-mint17 on 16.02.15.
 */
public class TimeUtil {
    private static final long TIME_TEST = 1424097008608L;
    private final long actualTime;
    private final String LOG_TAG = App.LOG_TAG +
            this.getClass().getSimpleName();
    private Context context;

    public TimeUtil(Context context) {
        this.context = context;
        actualTime = getCurrentTime();
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getToday() {
        Date date = new Date(actualTime - actualTime % (24 * 60 * 60 * 1000)
                - (2 * 60 * 60 * 1000));
        return date.getTime();
    }

    public long getYesterday() {
        Date date = new Date(actualTime - actualTime % (24 * 60 * 60 * 1000) - (24 * 60 * 60 * 1000)
                - (2 * 60 * 60 * 1000));
        return date.getTime();
    }

    public String getCurrentFormatTimeMark(long timeMessage) {
        StringBuilder answer = new StringBuilder();
        long mTimeMessage = timeMessage;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mTimeMessage);
        CharSequence mTime = DateFormat.format("kk:mm", mTimeMessage);
        Log.d(LOG_TAG, "mTimeMessage1=" + calendar.getTime().toString());
        if (mTimeMessage >= getToday()) {
            answer.append(context.getResources().getString(R.string.today) + " " + mTime);
        } else if (mTimeMessage < getToday() && mTimeMessage >= getYesterday()) {
            answer.append(context.getResources().getString(R.string.yesterday) + " " + mTime);
        } else if (mTimeMessage < getYesterday()) {
            answer.append(calendar.get(Calendar.DAY_OF_MONTH) + " "
                    + context.getResources().getStringArray(R.array.month)[calendar.get(Calendar.MONTH)] + " "
                    + context.getResources().getString(R.string.in) + " " + mTime);
        }
        Log.d(LOG_TAG, answer.toString());
        return answer.toString();
    }

    public String getCurrentFormatTimeMessage(long timeMessage) {
        StringBuilder answer = new StringBuilder();
        long mTimeMessage = timeMessage;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(mTimeMessage);
        CharSequence mTime = DateFormat.format("kk:mm", mTimeMessage);
        Log.d(LOG_TAG, "mTimeMessage1=" + calendar.getTime().toString());
        if (mTimeMessage >= getToday()) {
            answer.append(mTime);
        } else if (mTimeMessage < getToday() && mTimeMessage >= getYesterday()) {
            answer.append(context.getResources().getString(R.string.yesterdayMessager));
        } else if (mTimeMessage < getYesterday()) {
            answer.append(DateFormat.format("dd.MM.yyyy", mTimeMessage));
        }
        Log.d(LOG_TAG, answer.toString());
        return answer.toString();
    }
}
