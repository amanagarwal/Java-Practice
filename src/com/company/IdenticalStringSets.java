package com.company;

import java.util.HashSet;

/**
 * Created by Aman Agarwal on 9/28/14.
 */

/*
Assumptions:
- Equivalent = The various distinct strings need to be present in all the sets.
- If sets is an empty array or an array that contains empty arrays, then the function processes it as if it were identical and returns "true"
- HashMap vs. HashSet = Based on our previous assumption we need to use a HashSet as we don't care about duplicates (hence key, value pairs
aren't needed)
 */

public class IdenticalStringSets {

    public static void main(String[] args) {
        String[][] test1 = {{"a", "c"}, {"c", "c", "a"}, {"c", "a"}, {"c", "a", "a", "c", "a"}};
        String[][] test2 = {{"a", "b"},{"b", "b", "a"},{"b", "a"}};
        String[][] test3 = {{"a", "b"}, {"a"}, {"b"}};
        String[][] test4 = {};
        System.out.println(allStringSetsIdentical(test1));
        System.out.println(allStringSetsIdentical(test2));
        System.out.println(allStringSetsIdentical(test3));
    }

    /*
    allStringSetsIdentical takes in an array of arrays that contain sets of strings and returns true if all the sets are equivalent
    and false otherwise.
     */

    public static boolean allStringSetsIdentical(String[][] sets) {
        if (sets.length > 0) {
            HashSet<String> baseSet = addToSet(sets[0]);        //adding first set of strings to a HashSet to use as benchmark

            for (int i = 1; i < sets.length; i++) {
                HashSet<String> newSet = addToSet(sets[i]);
                if (!baseSet.equals(newSet)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
    addToSet takes in a string array (a temporary array that will iterate over the rest of the sets of strings) and adds the strings items
    contained within it and adds them to a HashSet
     */
    public static HashSet<String> addToSet(String[] iteratorArray) {
        HashSet<String> iteratorSet = new HashSet<String>();
        for (int i = 0; i < iteratorArray.length; i++) {
            iteratorSet.add(iteratorArray[i]);
        }
        return iteratorSet;
    }
}