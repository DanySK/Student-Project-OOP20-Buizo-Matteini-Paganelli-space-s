package CommandProva.ShipMovement;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class ShipSurvPanel extends JPanel implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Ship ship;
	Timer gameTimer;
	
	public ShipSurvPanel(Physics physics) {
		
		ship = new Ship(400, 300, this);
		
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				ship.set(physics);
				repaint();
			}
			
		}, 0, 17);
		//60 FPS.
	}
	
	


	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;	
		
		ship.draw(gtd);	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
