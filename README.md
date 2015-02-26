# Java-Practice
3 coding questions

QUESTION #1:

Write a Java method that takes an array of "sets" of String objects,
and determines whether _all_ sets in the array are equivalent.

Each "set" in the input array is represented as an array of String objects, in 
no particular order, and possibly containing duplicates. Nevertheless, when
determining whether two of these "sets" are equivalent, you should disregard
order and duplicates. For example, the sets represented by these arrays are
all equivalent:

{"a", "b"}
{"b", "a"}
{"a", "b", "a"}

The signature for your method should be:

public static boolean allStringSetsIdentical(String[ ][ ] sets)

Examples of the method in operation:

allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
returns true

allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false

QUESTION #2:

//
// The following Java code is responsible for creating an HTML "SELECT"
// list of U.S. states, allowing a user to specify his or her state. This might
// be used, for instance, on a credit card transaction screen. 
//
// Please rewrite this code to be "better". Submit your replacement code, and
// please also submit a few brief comments explaining why you think your code
// is better than the sample.
//
// (For brevity, this sample works for only 5 states. The real version would
// need to work for all 50 states. But it is fine if your rewrite shows only
// the 5 states here.)
//

public class StateUtils {

  //
  // Generates an HTML select list that can be used to select a specific
  // U.S. state.
  //
  public static String createStateSelectList()
  {
    return
      "<select name=\"state\">\n"
    + "<option value=\"Alabama\">Alabama</option>\n"
    + "<option value=\"Alaska\">Alaska</option>\n"
    + "<option value=\"Arizona\">Arizona</option>\n"
    + "<option value=\"Arkansas\">Arkansas</option>\n"
    + "<option value=\"California\">California</option>\n"
    // more states here
    + "</select>\n"
    ;
  }

  //
  // Parses the state from an HTML form submission, converting it to
  // the two-letter abbreviation. We need to store the two-letter abbreviation
  // in our database.
  //
  public static String parseSelectedState(String s)
  {
    if (s.equals("Alabama"))     { return "AL"; }
    if (s.equals("Alaska"))      { return "AK"; }
    if (s.equals("Arizona"))     { return "AZ"; }
    if (s.equals("Arkansas"))    { return "AR"; }
    if (s.equals("California"))  { return "CA"; }
    // more states here
  }

  //
  // Displays the full name of the state specified by the two-letter code.
  //
  public static String displayStateFullName(String abbr) {
  {
    if (abbr.equals("AL")) { return "Alabama";    }
    if (abbr.equals("AK")) { return "Alaska";     }
    if (abbr.equals("AZ")) { return "Arizona";    }
    if (abbr.equals("AR")) { return "Arkansas";   }
    if (abbr.equals("CA")) { return "California"; }
    // more states here
  }

}

QUESTION #3:

Write a Java method that takes a String of text and inserts newline characters 
('\n') so that each line of text in the returned String has at most maxCharsPerLine
characters (not counting the newline). It may also be necessary to delete some spaces.

The method should obey the following rules:

1. Words should never be broken up, unless a word has more than maxCharsPerLine
characters in it.
2. A word is any sequence of characters that contains no spaces and no newlines.
3. Existing line breaks should be preserved.
4. Lines should not be made shorter than necessary. In other words, if an 
additional word would fit on a line it should go on that line.
5. Words should be separated by either a single space or by one or more newlines.
6. Lines cannot start or end with spaces.

Assume that the text does not contain any other whitespace characters besides
spaces and newlines.

The signature for your method should be:

public static String wrapText(String text, int maxCharsPerLine)
