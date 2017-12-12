package demo.nytimes.vishaan.com.newyorktimesdemo.utils;

import android.util.Log;

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
}
