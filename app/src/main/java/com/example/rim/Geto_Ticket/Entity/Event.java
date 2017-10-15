package com.example.rim.Geto_Ticket.Entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rim on 27/03/17.
 */

public class Event implements Parcelable {
    private String title;
    private String photoUrl;
    private Map<String, String> options = new HashMap<>();
    private Location location;
    private String description;
    private Map<String, Boolean> hostsMails = new HashMap<>();
    private String numSeats;
    private String reserved;
    private String timeDate;

    public Event() {
    }

    public Event(String title, String photoUrl, Map<String, String> options, Location location, String description, Map<String, Boolean> hostsMails, String numSeats, String timeDate) {
        this.title = title;
        this.photoUrl = photoUrl;
        this.options = options;
        this.location = location;
        this.description = description;
        this.hostsMails = hostsMails;
        this.numSeats = numSeats;
        this.timeDate = timeDate;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Boolean> getHostsMails() {
        return hostsMails;
    }

    public void setHostsMails(Map<String, Boolean> hostsMails) {
        this.hostsMails = hostsMails;
    }

    public String getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(String numSeats) {
        this.numSeats = numSeats;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.photoUrl);
        dest.writeInt(this.options.size());
        for (Map.Entry<String, String> entry : this.options.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
        dest.writeParcelable(this.location, flags);
        dest.writeString(this.description);
        dest.writeInt(this.hostsMails.size());
        for (Map.Entry<String, Boolean> entry : this.hostsMails.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeValue(entry.getValue());
        }
        dest.writeString(this.numSeats);
        dest.writeString(this.reserved);
        dest.writeString(this.timeDate);
    }

    protected Event(Parcel in) {
        this.title = in.readString();
        this.photoUrl = in.readString();
        int optionsSize = in.readInt();
        this.options = new HashMap<String, String>(optionsSize);
        for (int i = 0; i < optionsSize; i++) {
            String key = in.readString();
            String value = in.readString();
            this.options.put(key, value);
        }
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.description = in.readString();
        int hostsMailsSize = in.readInt();
        this.hostsMails = new HashMap<String, Boolean>(hostsMailsSize);
        for (int i = 0; i < hostsMailsSize; i++) {
            String key = in.readString();
            Boolean value = (Boolean) in.readValue(Boolean.class.getClassLoader());
            this.hostsMails.put(key, value);
        }
        this.numSeats = in.readString();
        this.reserved = in.readString();
        this.timeDate = in.readString();
    }

    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
