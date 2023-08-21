package Wordle;

import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Chris
 */
public class Alphabet {
    
    // List to be used to print a colored alphabet
    public static List<Character> greenLetters = new ArrayList<>();
    public static List<Character> yellowLetters = new ArrayList<>();
    public static List<Character> greyLetters = new ArrayList<>();
    
    // Declaring the background colors
        public static final String RESET = "\u001B[0m";
        public static final String GREEN = "\u001B[42m";
        public static final String YELLOW = "\u001B[43m";
        public static final String GREY = "\u001B[100m";
    
    // print the alphabet with the associated colour for each letter
    public static String getAlphabet() {
        char c;
        String alphabet = "";

        for (c = 'A'; c <= 'Z'; ++c) {
            if (greenLetters.contains(c)) {
                alphabet = alphabet + GREEN + c + RESET + " ";
            } else if (yellowLetters.contains(c)) {
                alphabet = alphabet + YELLOW + c + RESET + " ";
            } else if (greyLetters.contains(c)) {
                alphabet = alphabet + GREY + c + RESET + " ";
            } else {
                alphabet = alphabet + c + " ";
            }
        }

        return alphabet;
    }
    
}
