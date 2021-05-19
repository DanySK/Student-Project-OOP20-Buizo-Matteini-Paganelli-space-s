package model.command.concreteCommand;

import model.command.commandInterfaces.CommandMovement;
import model.gameObject.MainGameObject;
import model.common.V2d;

public class LeftCommand implements CommandMovement{
	
	public LeftCommand() {}

	@Override
	public void execute(MainGameObject ship) {
		
		V2d vel = ship.getVelocity();

		ship.setVelocity(vel.sum(new V2d(-1,0)));
		System.out.println("Left " + ship.toString());

		
//		if (ctrl.isMoveUp()){
//			double speed = ball.getCurrentVel().module();
//			ball.setVel(new V2d(0,1).mul(speed));
//		} else if (ctrl.isMoveDown()){
//			double speed = ball.getCurrentVel().module();
//			ball.setVel(new V2d(0,-1).mul(speed));
//		} else if (ctrl.isMoveLeft()){
//			double speed = ball.getCurrentVel().module();
//			ball.setVel(new V2d(-1,0).mul(speed));			
//		} else if (ctrl.isMoveRight()){
//			double speed = ball.getCurrentVel().module();
//			ball.setVel(new V2d(1,0).mul(speed));			
//		}
	}


}
