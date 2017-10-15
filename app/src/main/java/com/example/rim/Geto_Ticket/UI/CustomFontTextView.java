package com.example.rim.Geto_Ticket.UI;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by rim on 25/03/17.
 */

public class CustomFontTextView extends android.support.v7.widget.AppCompatTextView{


    public CustomFontTextView(Context context) {
        super(context);
        CustomFontUtils.applyCustomFont(this, context, null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontUtils.applyCustomFont(this, context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontUtils.applyCustomFont(this, context, attrs);
    }

}
