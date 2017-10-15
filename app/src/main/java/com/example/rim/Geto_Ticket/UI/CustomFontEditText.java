package com.example.rim.Geto_Ticket.UI;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by rim on 26/03/17.
 */

public class CustomFontEditText extends android.support.v7.widget.AppCompatEditText{


    public CustomFontEditText(Context context) {
        super(context);
        CustomFontUtils.applyCustomFont(this, context, null);
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        CustomFontUtils.applyCustomFont(this, context, attrs);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        CustomFontUtils.applyCustomFont(this, context, attrs);
    }

}
