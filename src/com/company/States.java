package com.company;

import java.util.HashMap;

/**
 * Created by Aman Agarwal on 9/28/14.
 */

public class States {

    public static void main(String[] args) {
        addToMap();
        System.out.println(createStateSelectList());
        String CA = "CA";
        String NY = "NY";
        String FL = "FL";
        System.out.println(displayedStateFullName(CA));
        System.out.println(displayedStateFullName(NY));
        System.out.println(displayedStateFullName(FL));
        String California = "California";
        String New_York = "New York";
        String Florida = "Florida";
        System.out.println(parseSelectedState(California));
        System.out.println(parseSelectedState(New_York));
        System.out.println(parseSelectedState(Florida));
    }

    public static final String[] LETTER_ABBREVIATIONS = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    public static final String[] ALL_STATES = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

    public static HashMap<String, String> abbreviationsToStateNameMap = new HashMap<String, String>();

    /*
    addToMap populates our HashMap "abbreviationsToStateNameMap" with the two-letter abbreviation as the key and the name of the associated state as the value
     */
    public static void addToMap() {
        for (int i = 0; i < LETTER_ABBREVIATIONS.length; i++) {
            abbreviationsToStateNameMap.put(LETTER_ABBREVIATIONS[i], ALL_STATES[i]);
        }
    }

    /*
    createStateSelectList generates an HTML list that acts as a select dropdown for choosing a state
     */
    public static String createStateSelectList() {
        StringBuilder sb = new StringBuilder("<select name=\"state\">\n");
        for (int i = 0; i < ALL_STATES.length; i++) {
            sb.append("<option value=\"" +ALL_STATES[i]+ "\">" +ALL_STATES[i]+ "</option>\n");
        }
        sb.append("</select>\n");
        return sb.toString();
    }

    /*
    parseSelectedState takes in a string s, which is a state name that maps to the two-letter abbreviation in the map and returns the abbreviation for it.
     */
    public static String parseSelectedState(String s) {
        for (String str : abbreviationsToStateNameMap.keySet()) {
            if (abbreviationsToStateNameMap.get(str).equals(s)) {   //this will always hit true assuming data is not bad
                return str;
            }
        }
        return null;    //in the event of bad data input
    }

    /*
    displayedStateFullName takes in a string abbr, which is the two letter code that maps to a state in the map and returns the name of it.
     */
    public static String displayedStateFullName(String abbr) {
        String stateName = abbreviationsToStateNameMap.get(abbr);
        return stateName;
    }
}