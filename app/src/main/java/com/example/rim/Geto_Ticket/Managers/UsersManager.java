package com.example.rim.Geto_Ticket.Managers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.example.rim.Geto_Ticket.Entity.User;
import com.example.rim.Geto_Ticket.Managers.FireTools.TheConstants;
import com.example.rim.Geto_Ticket.Managers.FireTools.TheUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by rim on 26/03/17.
 */

public class UsersManager {
    private DatabaseReference mDatabase;
    private SharedPreferences mSharedPref;
    private SharedPreferences.Editor mSharedPrefEditor;

    public UsersManager(){
        mDatabase= FirebaseDatabase.getInstance().getReference();

    }

    public void fisrtUpdateUser(String userName, String email, String phoneNumber){
        User newUser=new User(userName, email, phoneNumber,null);
        mDatabase.child("users").child(TheUtils.encodeEmail(email)).setValue(newUser);
    }

    public void getCurrentUser(Context context, String email){
        mSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        mSharedPrefEditor = mSharedPref.edit();
        mDatabase.child("users").child(TheUtils.encodeEmail(email)).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                Log.v("rim",user.getUsername());
                mSharedPrefEditor.putString(TheConstants.KEY_USERNAME, user.getUsername()).apply();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
