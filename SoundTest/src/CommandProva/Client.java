package CommandProva;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;



public class Client {

	
	
	
	public static void main (String[] args) {
		
		MovementKeyListener mkl = new MovementKeyListener();
		JFrame frame = new JFrame("Key Listener Demo, patternata per bene");
		frame.setSize(500, 500);


		JPanel panel = new JPanel();

		  
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);


		frame.getContentPane().add(BorderLayout.CENTER, panel);
	    frame.addKeyListener(mkl);
	    frame.setVisible(true);
		
		}
	
	
}
