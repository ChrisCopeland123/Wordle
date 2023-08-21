
package Wordle;

import java.util.List;
import java.util.ArrayList;


/**
 * Client for Word game
 * Methods to play the game.
 * @author Chris copeland
 */
public class Client {
    
       
    // Method to determine the position of the guess letter in the word. 
    // Returns a formated string with _ letter not in word, 
    // lowercase letter in word but in a different location
    // Uppercase letter letter in in correct position
    
    // Declaring the background colors
        public static final String RESET = "\u001B[0m";
        public static final String GREEN = "\u001B[42m";
        public static final String YELLOW = "\u001B[43m";
        public static final String GREY = "\u001B[100m";
        
        
    
    public static String getPosition(String w, String g ) {
        String position = ""; // formated output string    
     
        // Convert the strings to arrays
        char[] guessChars = g.toCharArray();
        char[] wordChars = w.toCharArray();
        
        // loop counter to loop of guesss
        int j = 0; // guess position counter
        
        for (int i=0; i < g.length(); i++) {
            if (w.indexOf(guessChars[i]) > -1) {
                
                if (guessChars[j] == wordChars[j] ) {
                    position = position + GREEN + guessChars[i] + RESET + " ";
                } else {
                    position = position + YELLOW + guessChars[i] + RESET + " ";
                }
            }
            else {
                    position = position + GREY + guessChars[i] + RESET + " ";
                        }
        
            j++;

        }
       
        return position; 
    }
    // returns a different input string if first guess
    public static String getInputString(int c) {
        String inputString ;
        
        if (c == 0) {
            inputString = "Enter your first guess";
        } else {
            inputString = "Enter another guess";
        }
        
        return inputString;
        
    }
    
    // Returns a formated end of game string depending on outcome.
    public static String getEndOfGame(boolean o, String w, int c){
        String outputString;
        
        if (o) {
        outputString = String.format("Guesses left: %d", 5-c);
        } else if (c == 5) {
            outputString = String.format("Game over - you lost. The word is %s ", w);
        } else {
            outputString = String.format("Game over you won in %d moves", c);
        } 
        
        
        return outputString;
    } 
    // method checks the validity of the guess by return true if guess is valid otherwise false
    // checks message length, is not null or empty, has only alabet letters, and is in the wordlist.
    public static boolean checkLetters(String g, List<String> wl) {
        // Return false if string is null or empty
        if (g == null || g.equals("")) {
            return false;            
        }
        
        // return false if < 5 characters
        if (g.length() < 5) {
            return false;
        }
        
        // return false if guess not in word list
        if (!wl.contains(g.toUpperCase())) {
            System.out.println("Guess is not in the word list");
            return false;
        }
        
        // Iterate over string checking letters
        for (int i =0; i < g.length(); i++) {
        // Check if character is a letter
        if (!Character.isLetter(g.charAt(i)) ){
        return false;
            }
        }
    
    return true;
}
    
    public static String gameInstructions(){
        String s = String.join(
        System.getProperty("line.separator"),
                "GAME INSTRUCTIONS - please read carefully",
                "---------------------------------------------------------------------------",
            "The game starts automatically and you are required to guess a random 5",
            "letter word. For each guess the server returns underscores if there are no",
            "common letters in the guess or the word, a lowercase letter if the letter",
            "is in the word but in a different position in the guess and an upper case",
            "letter if the letter is in the word and in the correct postion in both the",
            "guess and the word. After each guess the server returns all your previous",
            "guesses along with the current guess.",
            "To exit at any time press enter only.",
            "---------------------------------------------------------------------------" 
            );
                
        
        return s;
    }
    
    
}
