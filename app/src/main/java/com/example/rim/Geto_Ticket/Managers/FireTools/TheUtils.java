package com.example.rim.Geto_Ticket.Managers.FireTools;

/**
 * Created by rim on 26/03/17.
 */

public class TheUtils {
    public static String encodeEmail(String userEmail) {
        return userEmail.replace(".", ",");
    }
    public static String decodeEmail(String userEmail) {
        return userEmail.replace(",", ".");
    }
}
