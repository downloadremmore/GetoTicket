package com.example.rim.Geto_Ticket.UI.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rim.Geto_Ticket.Entity.Event;
import com.example.rim.Geto_Ticket.Managers.EventsManager;
import com.example.rim.Geto_Ticket.Managers.FireTools.TheConstants;
import com.example.rim.Geto_Ticket.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.squareup.picasso.Picasso;

/**
 * Created by rim on 27/03/17.
 */

public final class EventDetailsActivity extends AppCompatActivity implements View.OnClickListener {
    Event event;
    ImageView imageEvent,QRimageView;
    TextView eventName, date, description, numSeats;
    Button ticketButton;
    public final static int QRcodeWidth = 500 ;
    Bitmap bitmap ;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details);
        Bundle args = getIntent().getExtras();
        event = args.getParcelable("event");
        Log.i("cc", "onItemClicked - community.name:" + event.getTitle());

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle(event.getTitle());

        imageEvent = (ImageView) findViewById(R.id.cover_image);
        QRimageView =(ImageView) findViewById(R.id.qrcode_image);
        eventName = (TextView) findViewById(R.id.title_info_textview);
        date = (TextView) findViewById(R.id.date_info_textview);
        description = (TextView) findViewById(R.id.description_info_textview);
        numSeats = (TextView) findViewById(R.id.seats_info_textview);
        ticketButton = (Button) findViewById(R.id.getticket_bt);

        Picasso.with(this).load(event.getPhotoUrl()).into(imageEvent);
        eventName.setText(event.getTitle());
        date.setText(event.getTimeDate());
        description.setText(event.getDescription());
        numSeats.setText(event.getNumSeats());
        ticketButton.setOnClickListener(this);
    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.colorPrimaryDark):getResources().getColor(R.color.white);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event_menu, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        try {
            SharedPreferences mSharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            String name = mSharedPref.getString(TheConstants.KEY_USERNAME, null);
            int numReservedSeats = Integer.parseInt(event.getReserved())+1;
            Log.v("Geto", "name: "+name);
            String key = name.concat(event.getTitle()).concat(Integer.toString(numReservedSeats));
            String userMail = mSharedPref.getString(TheConstants.KEY_EMAIL, null);
            new EventsManager().updateReservedSeats(event.getTitle(), numReservedSeats, userMail, key);
            bitmap = TextToImageEncode(key);
            QRimageView.setImageBitmap(bitmap);
            ;

        } catch (WriterException e) {
            e.printStackTrace();
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_staff) {
            startActivity(new Intent(this, ScannerActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
