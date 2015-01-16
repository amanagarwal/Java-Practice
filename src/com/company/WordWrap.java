package com.company;

/**
 * Created by Aman Agarwal on 9/28/14.
 */

/*
Assumptions:
- In order to not break a word (unless necessary), if a word  is taking us above the specified limit, we put a newline character there and start at the next line.
 */

public class WordWrap {
    public static void main(String[] args) {
        String test1 = "The quick brown fox jumps over the lazy dog \n the quick brown fox jumps over the lazy dog \n the quick brown fox jumps over the lazy dog \n the quick brown fox jumps over the lazy dog";
        System.out.println(wrapText(test1, 10));
    }

    public static String wrapText(String text, int maxCharsPerLine) {
        StringBuilder wrappedText = new StringBuilder();
        StringBuilder wordBuilder = new StringBuilder();
        int i = 0, index = 0, textLength = text.length();

        if (maxCharsPerLine <= 0) {   //handling exceptions
            return "";
        }

        while (i < textLength || wordBuilder.length() > 0) {    //either the input string is still being parsed or if there is a remainder left in the wordBuilder we continue doing work
            char c = ' ';
            if (i < textLength) {                               //forming a word to insert into lines since the rules are primarily centered around words (should not be broken/fit in same line etc.)
                c = text.charAt(i);
                if (c != '\n' && c != ' ') {                    //if there's a space or newline character we know that either the word or the sentence finished and that we need to go to line 38 where we append the space/newline char to our output string
                    wordBuilder.append(c);
                    i++;
                    continue;
                }
            }

            if (index != 0 && wordBuilder.length() > 0 && (index + 1) <= maxCharsPerLine) {   //once the iterator hits the empty space or newline character, the program checks to see if the index of a line is at the beginning or later (and performs this task if its later). The key thing to note here is that the program makes sure a word greater than maxCharsPerLine will not be printed on that line
                wrappedText.append(c);
                index++;
            }

            if (wordBuilder.length() <= maxCharsPerLine) {
                if (index + wordBuilder.length() <= maxCharsPerLine) {  //this makes sure that a word that's greater than maxCharsPerLine is not added to a line (which is aligned with our initial assumption where the exception case is when that long word starts a new line, which will never be the case here)
                    wrappedText.append(wordBuilder);
                    index += wordBuilder.length();                      //incrementing the index after having added a word to our output string
                    if (c == '\n') {
                        wrappedText.append(c);                          //to preserve newline characters
                    }
                    wordBuilder = new StringBuilder();
                    i++;
                }
                else {
                    if (wrappedText.charAt(wrappedText.length() - 1) == ' ') {
                        wrappedText.setCharAt(wrappedText.length() - 1, '\n');  //if there is a space at the end of the current point in the line.. and if the word is going to take us above the limit, we will replace the space character with a newline character and start on the next line (see personal assumption right below question prompt)
                    }
                    else {
                        wrappedText.append('\n');       //if there is a letter at the end of the line and the new word is going to take us above the limit, we are going to append the current point in the line with a newline character and then start at the next line for the next word
                    }
                }
            } else {
                wrappedText.append(wordBuilder.substring(0, maxCharsPerLine - index));  //if the word is longer than the maxCharsPerLine then the substring of it is printed on the current line and the rest of the string is stored in a variable that's appended to the next line
                wrappedText.append('\n');
                String rest = wordBuilder.substring(maxCharsPerLine - index);
                wordBuilder = new StringBuilder();
                wordBuilder.append(rest);
            }

            if (wrappedText.length() > 0 && wrappedText.charAt(wrappedText.length() - 1) == '\n')   //if the newline character is at the end of the output string, then we have completed a line and we must move on to a newline
                index = 0;  //resetting index of current line to start from the beginning
        }

        wrappedText.append(wordBuilder); //outside the loop as we are appending the remainder that goes in the last line of wrappedText

        return wrappedText.toString();
    }
}