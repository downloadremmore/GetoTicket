package com.example.rim.Geto_Ticket.UI.Fragment;

import com.example.rim.Geto_Ticket.Managers.FireTools.TheConstants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

/**
 * Created by rim on 27/03/17.
 */

public class AllEventsFragment extends EventsFragment {
    public AllEventsFragment(){}

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // String myUserId = getUid();
        Query AllCommunityQuery = databaseReference.child(TheConstants.FIREBASE_LOCATION_EVENTS);
        return AllCommunityQuery;
    }
}
