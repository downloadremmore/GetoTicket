package com.example.rim.Geto_Ticket.UI.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rim.Geto_Ticket.Entity.Event;
import com.example.rim.Geto_Ticket.R;
import com.squareup.picasso.Picasso;

/**
 * Created by rim on 27/03/17.
 */

public class EventViewHolder  extends RecyclerView.ViewHolder {

    private final View itemView;
    private final ImageView imageEventView;
    private final TextView titleView;
    private final TextView descriptionView;
    private Bitmap bmp;
    private String LOG_TAG = "CommunityViewHolder";


    public EventViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        titleView = (TextView) itemView.findViewById(R.id.card_title);
        descriptionView = (TextView) itemView.findViewById(R.id.card_text);
        imageEventView = (ImageView) itemView.findViewById(R.id.card_image);
    }

    public void bindToEvent(final Event event, Context context, final EventClickListener clickListener) {
        titleView.setText(event.getTitle());
        descriptionView.setText(event.getDescription());
        Picasso.with(context).load(event.getPhotoUrl()).into(imageEventView);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener == null) {
                    return;
                }

                if (view.getId() == itemView.getId()) {
                    clickListener.onItemClicked(event);
                }
            }
        };


        itemView.setOnClickListener(onClickListener);
    }

    public interface EventClickListener {
        void onItemClicked(Event event);
    }
}
