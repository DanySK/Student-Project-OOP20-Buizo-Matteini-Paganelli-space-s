package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.model.GameObject;
import common.V2d;

public class LeftCommand implements CommandMovement{
	
	public LeftCommand() {}

	@Override
	public void execute(GameObject ship) {
		System.out.println("Left");
		V2d vel = ship.getCurrentVel();
//
		ship.setVel(vel.sum(new V2d(-15,0)));

		
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
