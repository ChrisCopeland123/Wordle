
package Wordle;


/**
 * Client for Word game
 * Methods to play the game.
 * @author Chris copeland
 */
public class Client {
    
       
    // Method to determine the position of the guess letter in the word.    
    
    public static String getPosition(String w, String g ) {
        String position = ""; // formated output string
        
        // Covert the strings to arrays
        char[] guessChars = g.toCharArray();
        char[] wordChars = w.toCharArray();
        
        // loop counters
        int j = 0; // guess position counter
        
        for (int i=0; i < g.length(); i++) {
            if (w.indexOf(guessChars[i]) > -1) {
                
                if (guessChars[j] == wordChars[j] ) {
                    position = position + guessChars[i] + " ";
                } else {
                    position = position + Character.toLowerCase(guessChars[i]) + " ";
                }
            }
            else {
                    position = position + "_ ";
                        }    
                
            j++;
            
        }
       
        return position; 
    }
    
    public static String getInputString(int c) {
        String inputString ;
        
        if (c == 0) {
            inputString = "Enter your first guess";
        } else {
            inputString = "Enter another guess";
        }
        
        return inputString;
        
    }
    
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
    
    public static boolean checkLetters(String g) {
        // Return false if string is null or empty
        if (g == null || g.equals("")) {
            return false;            
        }
        
        // return false if < 5 characters
        if (g.length() < 5) {
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
    
    
    
    



