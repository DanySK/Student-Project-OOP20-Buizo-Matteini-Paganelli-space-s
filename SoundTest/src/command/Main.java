package command;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import OLD_input.MyKeyListener;
import physics.Client;

/**
 * Execution class to test the command pattern.
 * @author alberto paga
 *
 */
public class Main {
	public static void main(String[] args) {
		
	  Client client = new Client(new MyKeyListener());

	  JFrame frame = new JFrame("KeyListener Demo");
	  frame.setSize(500, 500);
	  
	  JPanel panel = new JPanel(new GridLayout(500, 500));
	  frame.getContentPane().add(BorderLayout.CENTER, panel);
      
	  client.startGame();
      

      frame.addKeyListener(client.getKeyListener());
      frame.setVisible(true);
	}
}
