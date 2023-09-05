/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Wordle;

import java.util.Scanner;

import java.util.List;

public class App {

    public String getGreeting() {
        return "Wecome to Wordle"; 
    }
    
    public static void main(String[] args) {
        // Server instance = new Server();
        List<String> wordlist = new Server().readDictionary("target.txt");
        String word = Server.getRandomWord(wordlist);
        int counter = 0;
        String input;
        String guess; 
        boolean gameOutcome = true;
        Scanner keyboard = new Scanner(System.in);
        
     // Print the target word and Header
     System.out.println(new App().getGreeting());
     System.out.println(word);
     System.out.println(wordlist.size());
     
     // Create text area
    //  new wordle_GUI();
    //  new TextFrame();
    // new GUI();
        
    // Print game instructions
    System.out.println(Client.gameInstructions());
    // Game logic    
    while (gameOutcome) {
    
    // Ask the user to input a guess        
    System.out.println(Client.getInputString(counter));
    input = keyboard.nextLine();
    
    // Check if guess is a valid guess
    
    if (Client.checkLetters(input, wordlist)) {
    // Change guess to uppercase    
    guess = input.toUpperCase();
    
    System.out.println(guess);
    
    // get the position string
    System.out.println(Client.getPosition(word, guess));

    // print alphabet
    System.out.println(Alphabet.getAlphabet());
    
    // update counter and outcome
    counter ++;
    gameOutcome = counter < 5 && !guess.equals(word);
    
    // Print the current game outcome.
    System.out.println(Client.getEndOfGame(gameOutcome, word, counter));
    }
    
    // Ask user to enter only words of 5 letters.
    else {
        System.out.println("Enter 5 letters only");
    }
        }
    keyboard.close();
    }
    
}
