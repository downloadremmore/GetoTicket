package com.example.rim.Geto_Ticket.Managers.decoder;

import android.app.Activity;
import android.content.DialogInterface;

/**
 * Created by rim
 */

public class FinishListener  implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener,
        Runnable {

    private final Activity mActivityToFinish;

    public FinishListener(Activity activityToFinish) {
        this.mActivityToFinish = activityToFinish;
    }

    public void onCancel(DialogInterface dialogInterface) {
        run();
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        run();
    }

    public void run() {
        mActivityToFinish.finish();
    }
}