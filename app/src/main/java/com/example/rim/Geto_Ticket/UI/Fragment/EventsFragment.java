package com.example.rim.Geto_Ticket.UI.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rim.Geto_Ticket.UI.Activity.EventDetailsActivity;
import com.example.rim.Geto_Ticket.Entity.Event;
import com.example.rim.Geto_Ticket.R;
import com.example.rim.Geto_Ticket.UI.views.EventViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by rim on 27/03/17.
 */

public abstract class EventsFragment extends Fragment {
    private static final String TAG = "EventsFragment";

    private DatabaseReference mDatabase;


    private FirebaseRecyclerAdapter<Event, EventViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    public EventsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.all_events_layout, container, false);
        mDatabase = FirebaseDatabase.getInstance().getReference();


        mRecycler = (RecyclerView) rootView.findViewById(R.id.communities_list);
        mRecycler.setHasFixedSize(true);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mManager = new LinearLayoutManager(getActivity());
        mManager.setReverseLayout(true);
        mManager.setStackFromEnd(true);
        mRecycler.setLayoutManager(mManager);

        // Set up FirebaseRecyclerAdapter with the Query
        Query postsQuery = getQuery(mDatabase);
        mAdapter = new FirebaseRecyclerAdapter<Event, EventViewHolder>(Event.class, R.layout.item_event,
                EventViewHolder.class, postsQuery) {

            @Override
            protected void populateViewHolder(final EventViewHolder viewHolder, final Event model, final int position) {
                final DatabaseReference postRef = getRef(position);

                final String postKey = postRef.getKey();
                viewHolder.bindToEvent(model,getContext(), new EventViewHolder.EventClickListener() {
                    @Override
                    public void onItemClicked(Event event) {
                        Log.i(TAG, "onItemClicked - community.name:" + event.getTitle());
                        Bundle args = new Bundle();
                        args.putParcelable("event", event);
                        Intent intent = new Intent(getActivity(), EventDetailsActivity.class);
                        intent.putExtras(args);
                        startActivity(intent);

                    }
                });
            }
        };
        mRecycler.setAdapter(mAdapter);
    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mAdapter != null) {
            mAdapter.cleanup();
        }
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }

    public String getemail() {
        return FirebaseAuth.getInstance().getCurrentUser().getEmail();
    }

    public abstract Query getQuery(DatabaseReference databaseReference);



}
