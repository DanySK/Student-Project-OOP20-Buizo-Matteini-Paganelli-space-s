package CommandProva.ShipMovement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ship {
	
	ShipSurvPanel panel;
	int x;
	int y; 
	//sara un point2d;
	int width;
	int height;

	
	Rectangle hitBox;

	public Ship(int x, int y, ShipSurvPanel panel) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.hitBox = new Rectangle(this.x, this.y, this.width, this.height);
		
	}

	public void set(Physics physics) {
		
		//Horizontal collision
		//hitBox.x += (int) physics.getXSpeed();
	
		//Vertical collision
		//hitBox.y += (int) physics.getYSpeed();

		//physics.getXSpeed();
		this.x += (int) physics.getXSpeed();
		this.y += (int) physics.getYSpeed();
		
		this.hitBox.x = this.x;
		this.hitBox.y = this.y;

	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.BLACK);
		gtd.fillRect(this.x,  this.y,  this.width,  this.height);
			
	}

}
