package com.americanairlines.appxmvvm.util;

import android.util.Log;

public class DebugLogger {

    public static final String TAG = "TAG_X";
    public static final String TAG_ERROR = "TAG_ERROR";

    public static void logDebug(String debugMessage){
        Log.d(TAG, debugMessage);
    }

    public static void logError(String errorMessage){
        Log.d(TAG_ERROR, errorMessage);
    }
}
