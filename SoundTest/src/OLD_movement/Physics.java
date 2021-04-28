package OLD_movement;



public class Physics {
	
	private double xSpeed = 0;
	private double ySpeed = 0;
	
	private static final int MAX_X_SPEED = 120;
	private static final int MAX_Y_SPEED = 120;
	
	private static final int MIN_X_SPEED = -120;
	private static final int MIN_Y_SPEED = -120;
	
	public Physics() {}
	
	public double getXSpeed() {
		return this.xSpeed;
	}
	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}
	
	public double getYSpeed() {
		return this.ySpeed;
	}
	public void setYSpeed(double ySpeed) {
		this.ySpeed = ySpeed;
	}
	
	public void resetXSpeed() {	
		
		this.xSpeed = 0;
//		while(this.xSpeed > 0.0) {
//			this.xSpeed -= 0.5;
//			try {
//				TimeUnit.MILLISECONDS.sleep(5);
//				System.out.println(xSpeed);
//				
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//
//		}

	}
	
	public void resetYSpeed() {
		
		this.ySpeed = 0;
		
//		while(this.ySpeed > 0.0) {
//			this.ySpeed -= 0.5;
//			try {
//				TimeUnit.MILLISECONDS.sleep(5);
//				System.out.println(ySpeed);
//				
//			} catch (InterruptedException e) {
//				
//				e.printStackTrace();
//			}
//
//		}

	}
	

	
	
	public void increaseXSpeed(){		
		if(this.xSpeed < 0) {
			this.xSpeed = 3;
		}
	
		if(this.xSpeed < MAX_X_SPEED) {
			xSpeed += 10;
		}	
	}
	
	public void decreaseXSpeed(){
		if(this.xSpeed > 0) {
			this.xSpeed = -3;
		}
		if(this.xSpeed > MIN_X_SPEED) {
			xSpeed -= 10;
		}	
	}
	
	public void increaseYSpeed(){
		if(this.ySpeed < 0) {
			this.ySpeed = 3;
		}
		if(this.ySpeed < MAX_Y_SPEED) {
			ySpeed += 10;
		}	
	}
	
	public void decreaseYSpeed(){
		if(this.ySpeed > 0) {
			this.ySpeed = -3;
		}
		if(this.ySpeed > MIN_Y_SPEED) {
			ySpeed -= 10;
		}	
	}
	

}
