package com.example.rim.Geto_Ticket.UI.ui_tools;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by rim
 */

public class ScreenUtils {
    private ScreenUtils() {
        throw new AssertionError();
    }


    public static int getScreenWidth(Context context) {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int screenHeight = dm.heightPixels;
        return screenHeight;
    }

}
