package OLD_movement_collision;

import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class PlatformerGameTutorial {
	
	public static void main(String[] args) {
		System.out.println("Ciao mondo");
		MainFrame frame = new MainFrame();
		
		frame.setSize(700,700);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) (screenSize.getWidth()/2 - frame.getSize().getWidth()/2), (int)(screenSize.getSize().getHeight()/2 - frame.getSize().getHeight()/2));
		frame.setResizable(true);
		
		frame.setTitle("Gioco prova");
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}
