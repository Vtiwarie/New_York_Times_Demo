package demo.nytimes.vishaan.com.newyorktimesdemo.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import demo.nytimes.vishaan.com.newyorktimesdemo.BuildConfig;

/**
 * Created by vishaantiwarie on 12/12/17.
 */

public class Util {
    public static void logDebug(String tag, String message) {
        if(BuildConfig.DEBUG) {
            Log.d(tag, message);
        }
    }

    public static void logError(String tag, String message) {
        if(BuildConfig.DEBUG) {
            Log.e(tag, message);
        }
    }

    public static void toast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
