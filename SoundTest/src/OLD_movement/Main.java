package OLD_movement;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;


//import physics.Client;

/**
 * Execution class to test the command pattern.
 * @author alberto paga
 *
 */
public class Main {
	public static void main(String[] args) {
		
	  Physics phisics = new Physics();
	  //Client client = new Client(new MyKeyListener(phisics));

	  JFrame frame = new JFrame("Movement Demo");
	  frame.setSize(500, 500);
	  
	  ShipSurvPanel panel = new ShipSurvPanel(phisics);
//	  client.startGame();

	  
	  panel.setBackground(Color.LIGHT_GRAY);
	  panel.setVisible(true);


	  frame.getContentPane().add(BorderLayout.CENTER, panel);
     //frame.addKeyListener(client.getKeyListener());
      frame.setVisible(true);
	}
}
