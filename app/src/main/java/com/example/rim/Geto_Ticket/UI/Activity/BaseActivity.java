package com.example.rim.Geto_Ticket.UI.Activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.rim.Geto_Ticket.R;

/**
 * Created by rim on 26/03/17.
 */

class BaseActivity  extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

}