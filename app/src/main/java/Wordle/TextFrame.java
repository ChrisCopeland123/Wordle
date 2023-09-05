package Wordle;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chris
 */
public class  TextFrame extends Frame implements ActionListener  {
    
	JTextField tf1;
	JTextArea ta;  
    JButton b1,b2;  

// constructor 
		
	public TextFrame() {
	
	// instantiating and setting the location of components on the frame  
	JFrame f= new JFrame();  
	tf1=new JTextField();  
	tf1.setBounds(50,50,150,20);  
	// tf2=new JTextField();  
	// tf2.setBounds(50,100,150,20);  
	// tf3=new JTextField();  
	// tf3.setBounds(50,150,150,20);  
	// tf3.setEditable(false); 

		
	// create the buttons
	b1=new JButton("Enter");  
	b1.setBounds(50,200,50,50);  
	b2=new JButton("Exit");  
	b2.setBounds(120,200,50,50);  
	b1.addActionListener(this);  
	b2.addActionListener(this); 
	
	// add the elemnets to the frame
	f.add(tf1);
	f.add(b1);f.add(b2); 
	
	f.setSize(610,610);  
	f.setLayout(null);  
	f.setVisible(true);  	

	}

	// if the button is pressed
        @Override
	public void actionPerformed(ActionEvent e)	{

		String s1=tf1.getText();  
        // String s2=tf2.getText();  
        // int a=Integer.parseInt(s1);  
        // int b=Integer.parseInt(s2);  
        // int c=0;  
        if(e.getSource()==b1){  
            ta.setText(s1);  
        }else if(e.getSource()==b2){  
            System.exit(0);  
        }  
        // String result=String.valueOf(c);  
        // tf3.setText(result);  
	}
    
}
