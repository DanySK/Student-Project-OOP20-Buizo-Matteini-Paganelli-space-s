package movement_collision;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player {
	
	GamePanel panel;
	int x;
	int y; 
	//sara un point2d;
	int width;
	int height;
	
	double xSpeed;
	double ySpeed;
	
	Rectangle hitBox;
	
	boolean keyLeft;
	boolean keyRight;
	boolean keyUp;
	boolean keyDown;
	
	
	
	public Player(int x, int y, GamePanel panel) {
		this.panel = panel;
		this.x = x;
		this.y = y;
		
		this.width = 50;
		this.height = 50;
		
		this.hitBox = new Rectangle(this.x, this.y, this.width, this.height);
		
	}

	public void set() {
		
		if(keyLeft && keyRight || !keyLeft && !keyRight) xSpeed *= 0.8;
		else if(keyLeft && !keyRight) xSpeed = xSpeed - 1;	
		else if(!keyLeft && keyRight) xSpeed = xSpeed + 1;

		if(xSpeed > 0 && xSpeed < 0.75) xSpeed = 0;
		if(xSpeed < 0 && xSpeed > 0.75) xSpeed = 0;
		
		if(xSpeed > 7) xSpeed = 7;
		if(xSpeed < -7) xSpeed = -7;
		
		if(keyUp) {
			
			hitBox.y++;
			for(Wall wall: panel.walls) {
				
				if(wall.hitBox.intersects(hitBox)) {
					ySpeed = -5;
				}
				hitBox.y--;
				
			}		
		}
		
		ySpeed += 0.3;
		
		//Horizontal collision
		hitBox.x += xSpeed;
		for(Wall wall : panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.x -= xSpeed;
				while(!wall.hitBox.intersects(hitBox)) {
					hitBox.x += Math.signum(xSpeed);
				}
				hitBox.x -= Math.signum(xSpeed);
				xSpeed = 0;
				x = hitBox.x;
				
			}
		}
			
		
		//Vertical collision
		hitBox.y += ySpeed;
		for(Wall wall : panel.walls) {
			if(hitBox.intersects(wall.hitBox)) {
				hitBox.y -= ySpeed;
				while(!wall.hitBox.intersects(hitBox)) {
					hitBox.y += Math.signum(ySpeed);
				}
				hitBox.y -= Math.signum(ySpeed);
				ySpeed = 0;
				y = hitBox.y;
				
			}
		}
		
		
		
		
		
		
		

		this.x += this.xSpeed;
		this.y += this.ySpeed;
		
		this.hitBox.x = this.x;
		this.hitBox.y = this.y;
		
		
		
		
		
		
		
	}
	
	public void draw(Graphics2D gtd) {
		gtd.setColor(Color.BLACK);
		gtd.fillRect(this.x,  this.y,  this.width,  this.height);
		
		
	}

}
