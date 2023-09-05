package Wordle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import org.apache.logging.log4j.core.jmx.Server;

// import io.vertx.core.net.impl.pool.Executor.Action;
import java.awt.*;
// import java.util.List;
import java.util.ArrayList;
import java.util.ServiceLoader;

/**
 *
 * @author leawo
 */
public class GUI implements ActionListener {
    
   JFrame frame1;
    JButton startbutton;
    JPanel panel;
    JLabel instructionslabel1;
    JLabel instructionslabel2;
    JLabel instructionslabel3;
    JLabel instructionslabel4;
    JLabel instructionslabel5;
    JTextField text;
    boolean initial = true;
    String input;

    static final int boxSize = 64;
    static final int margin = 10;
    static final int gap = 5;
    static final int wordLength = 5;
    static final int guessMax = 6; 
    
    // The coordinate of the top or left of a the painting area for this row/col
    private int top(int row) {
        return margin + row * (gap + boxSize + gap);
    }

    private int left(int col) {
        return margin + col * (gap + boxSize + gap);
    }


    public GUI() {
        //Visual logic for setting up start screen
        
        // Creates window
        JFrame frame1 = new JFrame();
        // Creates button
        JButton startbutton = new JButton("Click me to start!");
        wordleCanvas wCanvas = new wordleCanvas("BLANK");
        JFrame frame2 = new JFrame();
        JPanel panel2 = new JPanel();
        JTextField text = new JTextField(20);
        text.setHorizontalAlignment(JTextField.CENTER);
        frame2.add(panel2, BorderLayout.CENTER);
        panel2.add(wCanvas);
        panel2.add(text);
        frame2.setTitle("Wordle Clone");
        frame2.pack();
        frame2.setSize(new Dimension(800, 600));
        frame2.setLocationRelativeTo(null);
        //switch to start the game
        
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // the input is the correct number of chars
                input = e.getActionCommand();
                if (input.length() == 5) {
                    // so we send it to the server
                    // the logic for this needs to be implemented
                    initial = false;
                    // just testing the input is recorded here
                    // String boolValue = " " + initial;
                    // frame2.setTitle(boolValue);
                    // frame2.setTitle(input);
                    wordleCanvas reloadedCanvas = new wordleCanvas(input);
                    panel2.add(reloadedCanvas);
                    wCanvas.setVisible(false);
                    frame2.pack();
                    frame2.revalidate();
                    frame2.repaint();
                }
            }
        }); 
        startbutton.addActionListener(new ActionListener() {
        

            @Override
            public void actionPerformed(ActionEvent e) {
                
                frame1.setVisible(false);
                frame2.setVisible(true);
                
            }
            
        });
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

    // public static void main(String[] args) {
    //     new GUI();
    // }
    
/* Canvas to draw the letters on 
     * Strongly derived froms Dots and Boxes
    */
    class wordleCanvas extends Canvas {
        final ArrayList<Box> boxes = new ArrayList<>();
        // A Baox contains a single guessed letter
        class Box {
            private int column;
            private int row;
            private String letter;
            Font font = new Font(Font.MONOSPACED, Font.BOLD, boxSize);

            public Box(int col, int row, String letter){
                this.column = col;
                this.row = row;
                this.letter = letter;
            }

            public void setLetter(String letter){
                this.letter = letter;
            }
            public String getLetter(){
                return this.letter;
            }

            int xOffset(){
                return (getWidth() - ((2 * margin) + wordLength * (gap + boxSize + gap)))/2;
            }

            Rectangle rect() {
                int x = left(this.column) + gap + xOffset();
                int y = top(this.row) + gap;
                return new Rectangle(x, y, boxSize, boxSize);
            }

            /** Whether or not this Box contains this point */
            boolean contains(int x, int y) {
                return rect().contains(x, y);
            }

            /** Paints this Box including the letter */
            public void draw(Graphics2D g2d) {
                
                // g2d.setFont(Box.font);
                // Calculate the coordinates for drawing the letter
                FontMetrics fm = g2d.getFontMetrics();
                int y = this.rect().y + this.rect().height + ((this.rect().height - fm.getHeight()) / 2);
                int x = this.rect().x + ((this.rect().width - fm.stringWidth(this.letter))/2);
                // Draw things
                g2d.setColor(Color.BLACK);
                g2d.fill(this.rect());
                g2d.setColor(Color.WHITE);
                g2d.drawRect(this.rect().x, this.rect().y, this.rect().width, this.rect().height);
                g2d.setColor(Color.GRAY);
                g2d.drawString(this.letter, x, y);

            }
        }

        public wordleCanvas(String word){
             // Size the canvas to just contain the elements
             
             int width = left(wordLength) + margin + boxSize;
             int height = top(guessMax) + margin + boxSize;
             this.setPreferredSize(new Dimension(width, height));

             // Create records for the boxes
            
            String[] chars = word.split("");
             for (int row = 0; row < guessMax; row++) {
                 for (int col = 0; col < wordLength; col++) {
                     boxes.add(new Box(col, row, chars[col]));
                 }
             }
                        

        }

        @Override public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D)g;

            g.clearRect(0, 0, this.getWidth(), this.getHeight());
            g2d.setColor(Color.gray);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            // Paint the boxes
            for (Box b : boxes) {
                b.draw(g2d);
            }

        }
    }

}

            

