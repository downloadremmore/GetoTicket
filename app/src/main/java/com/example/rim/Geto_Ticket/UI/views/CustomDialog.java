package com.example.rim.Geto_Ticket.UI.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rim.Geto_Ticket.R;

/**
 * Created by rim
 */

public class CustomDialog extends Dialog implements View.OnClickListener {
    ImageView qrCode;
    TextView TimeRemainingMsg, warningMsg;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_layout);
        qrCode = (ImageView)findViewById(R.id.qr_code_imageview);
        TimeRemainingMsg = (TextView)findViewById(R.id.time_remaining_tv);
        warningMsg = (TextView)findViewById(R.id.warning_msg_tv);
    }

    @Override
    public void onClick(View v) {

    }

}
