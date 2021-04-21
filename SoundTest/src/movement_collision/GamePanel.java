package movement_collision;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Player player;
	ArrayList<Wall> walls = new ArrayList<>();
	
	Timer gameTimer;
	
	public GamePanel() {
		
		player = new Player(400,300, this);
		
		makeWalls();
		
		gameTimer = new Timer();
		gameTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				player.set();
				repaint();
			}
			
		}, 0, 17);
		//60 FPS.
		
	}
	
	
	public void makeWalls() {
		
		for(int i = 50; i < 650; i += 50) {
			walls.add(new Wall(i, 600, 50, 50));
			
		}
		walls.add(new Wall(50, 550, 50, 50));
	}
	


	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D gtd = (Graphics2D) g;	
		
		player.draw(gtd);
		
		for(Wall wall : walls) {
			wall.draw(gtd);
		}
		
	}


	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == 37)  player.keyLeft 	= true;
		if(e.getKeyCode() == 38)  player.keyUp 		= true;
		if(e.getKeyCode() == 39)  player.keyRight	= true;
		if(e.getKeyCode() == 40)  player.keyDown 	= true;
		
	}


	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == 37)  player.keyLeft 	= false;
		if(e.getKeyCode() == 38)  player.keyUp 		= false;
		if(e.getKeyCode() == 39)  player.keyRight	= false;
		if(e.getKeyCode() == 40)  player.keyDown 	= false;
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}


	

	
}
