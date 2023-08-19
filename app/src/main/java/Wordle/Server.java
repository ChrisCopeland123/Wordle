package Wordle;

import java.util.*; 
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;



/**
 * This class reads in the text file and selects a random word
 * to use in the game.
 * @author chris
 */
public class Server {

    // Read the dictionary and assemble the dictionary arrayList from which to choose the random chosen word
    public List<String> readDictionary(String fileName) {

        List<String> wordList = new ArrayList<>();

        try {
            // Open and read the dictionary file
            InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
            assert in != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String strLine;

            //Read file line By line
            while ((strLine = reader.readLine()) != null) {
                wordList.add(strLine);
            }
            //Close the input stream
            in.close();

        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        return wordList;
    }
    
   // Get a random word from the dictionary arraylist
    public static String getRandomWord(List<String> wordList) {
        Random rand = new Random(); //instance of random class
        int upperbound = wordList.size();
        // generate random values from 0 to arrayList size
        int int_random = rand.nextInt(upperbound);
        return wordList.get(int_random);
    } 
    
}
