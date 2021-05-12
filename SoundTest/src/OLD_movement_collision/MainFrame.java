package OLD_movement_collision;

import java.awt.Color;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {	
		GamePanel panel = new GamePanel();
		panel.setLocation(0, 0);
		panel.setSize(this.getSize());
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setVisible(true);
		this.add(panel);
		
		addKeyListener(new KeyChecker(panel));
	}

	
	

}
