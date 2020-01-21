package com.example.taskexample.utils;

import android.util.Log;

public class LogUtils {
    public static final String TAG = "ANN_TAG";
    private static final boolean IS_DEBUG = true;

    public static void d(String value) {
        if (IS_DEBUG)
            Log.d(TAG, value);
    }
}
