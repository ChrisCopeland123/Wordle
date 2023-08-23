package Wordle;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class  TextFrame extends Frame implements ActionListener  {
    
Label l1, l2, l3;    
TextArea area;    
Button b;

// constructor 
		
	public TextFrame() {
	
	// instantiating and setting the location of components on the frame  
    l1 = new Label();    
    l1.setBounds(50, 100, 100, 30);    
    l2 = new Label();    
    l2.setBounds(160, 100, 100, 30); 
	l3 = new Label();
	l3.setBounds(20, 50, 100, 30 );   
    area = new TextArea("", 0, 0, TextArea.SCROLLBARS_NONE);    
    area.setBounds(20, 150, 300, 100);    
    b = new Button("Count Words");    
    b.setBounds(20, 400, 100, 30);
	
	// add a quit button
	JButton quitButton = new JButton("Quit");
	quitButton.setBounds(150, 400, 100, 30);
  
	// adding ActionListener to button  
    b.addActionListener(this); 
	quitButton.addActionListener(this);

  
	// adding components to frame  
    add(l1);  
	add(l2);
	add(l3);  
	add(area);  
	add(b);
	add(quitButton);   
// setting the size, layout and visibility of frame  
    setSize(400, 450);    
    setLayout(null);    
    setVisible(true);
	
	l3.setText("Heading");

	}

	// if the button is pressed
        @Override
	public void actionPerformed(ActionEvent e)	{

		String s = e.getActionCommand();

		if(s.equals("Quit")) {
			System.exit(0);
		} else {
		String text = area.getText();    
    	String words[]=text.split("\\s");    
    	l1.setText("Words: "+words.length);    
    	l2.setText("Characters: "+text.length());
		}  
	}
    
}
