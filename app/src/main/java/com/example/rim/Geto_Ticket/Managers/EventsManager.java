package com.example.rim.Geto_Ticket.Managers;

import com.example.rim.Geto_Ticket.Managers.FireTools.TheConstants;
import com.example.rim.Geto_Ticket.Managers.FireTools.TheUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rim on 27/03/17.
 */

public class EventsManager {
    private DatabaseReference mDatabase;

    public EventsManager(){
        mDatabase= FirebaseDatabase.getInstance().getReference();
    }

    public void updateReservedSeats(String eventName, int numReservedSeats,String mailUser, String generated){
        mDatabase.child(TheConstants.FIREBASE_LOCATION_EVENTS).child(eventName).child(TheConstants.FIREBASE_EVENTS_RESERVEDSITES).setValue(Integer.toString(numReservedSeats));
        mDatabase.child(TheConstants.FIREBASE_LOCATION_USERS).child(TheUtils.encodeEmail(mailUser)).child(TheConstants.FIREBASE_LOCATION_EVENTS).child(eventName).setValue(generated);
        mDatabase.child(TheConstants.FIREBASE_LOCATION_EVENTS).child(eventName).child(TheConstants.FIREBASE_LOCATION_USERS).child(TheUtils.encodeEmail(mailUser)).setValue(generated);
    }
}
