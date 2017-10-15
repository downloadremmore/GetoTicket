package com.example.rim.Geto_Ticket.Managers.decoder;

import android.os.Handler;
import android.os.Looper;

import com.example.rim.Geto_Ticket.UI.Activity.ScannerActivity;

import java.util.concurrent.CountDownLatch;

/**
 * Created by rim on 01/04/17.
 */

public final class DecodeThread extends Thread {

    private final ScannerActivity mActivity;
    private Handler mHandler;
    private final CountDownLatch mHandlerInitLatch;

    DecodeThread(ScannerActivity activity) {
        this.mActivity = activity;
        mHandlerInitLatch = new CountDownLatch(1);
    }

    Handler getHandler() {
        try {
            mHandlerInitLatch.await();
        } catch (InterruptedException ie) {
            // continue?
        }
        return mHandler;
    }

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DecodeHandler(mActivity);
        mHandlerInitLatch.countDown();
        Looper.loop();
    }

}

