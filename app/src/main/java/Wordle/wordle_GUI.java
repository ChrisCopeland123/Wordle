package Wordle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// import org.apache.logging.log4j.core.jmx.Server;

// import io.vertx.core.net.impl.pool.Executor.Action;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author leawo
 */
public class wordle_GUI implements ActionListener {
    
    JFrame frame1;
    JButton startbutton;
    JPanel panel;
    JLabel instructionslabel1;
    JLabel instructionslabel2;
    JLabel instructionslabel3;
    JLabel instructionslabel4;
    JLabel instructionslabel5;
    JTextField text;

    public wordle_GUI() {
        //Visual logic for setting up start screen
        
        // Creates window
        JFrame frame1 = new JFrame();
        // Creates button
        JButton startbutton = new JButton("Click me to start!");
        startbutton.addActionListener(this);
        // Creates objects that can display text/images
        JLabel instructionslabel1 = new JLabel("The game starts upon clicking below and you will be required to guess a random 5 letter word.");
        instructionslabel1.setHorizontalAlignment(JLabel.CENTER);
        JLabel instructionslabel2 = new JLabel("For each guess the server returns underscores if there are no common letters in the guess or the word,");
        instructionslabel2.setHorizontalAlignment(JLabel.CENTER);
        JLabel instructionslabel3 = new JLabel("a lowercase letter if the letter is in the word but in a different position in the guess");
        instructionslabel3.setHorizontalAlignment(JLabel.CENTER);
        JLabel instructionslabel4 = new JLabel("and an upper case letter if the letter is in the word and in the correct postion in both the guess and the word.");
        instructionslabel4.setHorizontalAlignment(JLabel.CENTER);
        JLabel instructionslabel5 = new JLabel("After each guess the server returns all your previous guesses along with the current guess.");
        instructionslabel5.setHorizontalAlignment(JLabel.CENTER);
        // Creates panel that can hold components, e.g. the labels just created
        JPanel panel = new JPanel();
        // Creates textfield
        JTextField text = new JTextField();
        text.setHorizontalAlignment(JTextField.CENTER);

        // Sets values for size, etc of frame, and adds components to panel
        frame1.setSize(800, 600);
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(instructionslabel1);
        panel.add(instructionslabel2);
        panel.add(instructionslabel3);
        panel.add(instructionslabel4);
        panel.add(instructionslabel5);
        panel.add(startbutton);
        frame1.add(panel, BorderLayout.CENTER);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Wordle Clone");
        frame1.pack();
        frame1.setVisible(true);
        frame1.setSize(new Dimension(800, 600));
        frame1.setLocationRelativeTo(null);
        
    }
    
    // In theory, clicking the start button will trigger the startgame function, which will replace start window with game
    // Currently doesn't work
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startbutton) {
            startgame();
        }
    }


    // function that will generate game assets and use the game logic to function
    public void startgame() {
        //Game logic
        // List<String> wordlist = new Server().readDictionary("target.txt");
        // String word = Server.getRandomWord(wordlist);
        // int counter = 0;
        // String input;
        // String guess; 
        // boolean gameOutcome = true;

        
    }
    
}
