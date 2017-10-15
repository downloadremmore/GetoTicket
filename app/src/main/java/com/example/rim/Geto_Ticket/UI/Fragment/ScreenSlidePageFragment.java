package com.example.rim.Geto_Ticket.UI.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.rim.Geto_Ticket.R;
import com.example.rim.Geto_Ticket.UI.CustomFontTextView;

/**
 * Created by rim on 26/03/17.
 */

public class ScreenSlidePageFragment extends Fragment {
    public static final String ARG_PAGE = "page";


    private int mPageNumber;


    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.tutorial_layout, container, false);

        switch (mPageNumber){
            case 0:
                ((CustomFontTextView) rootView.findViewById(R.id.tuto_textview)).setText(
                        getString(R.string.tuto0_text));
                ((ImageView) rootView.findViewById(R.id.tuto_imageview)).setImageDrawable(getResources().getDrawable(R.drawable.tuto0));
                break;
            case 1:
                ((CustomFontTextView) rootView.findViewById(R.id.tuto_textview)).setText(
                        getString(R.string.tuto1_text));
                ((ImageView) rootView.findViewById(R.id.tuto_imageview)).setImageDrawable(getResources().getDrawable(R.drawable.tuto1));
                break;
            case 2:
                ((CustomFontTextView) rootView.findViewById(R.id.tuto_textview)).setText(
                        getString(R.string.tuto2_text));
                ((ImageView) rootView.findViewById(R.id.tuto_imageview)).setImageDrawable(getResources().getDrawable(R.drawable.tuto2));
                break;
        }


        return rootView;
    }

    public int getPageNumber() {
        return mPageNumber;
    }
}
