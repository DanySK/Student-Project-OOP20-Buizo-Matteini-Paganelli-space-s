package spaceSurvival.model.command.concreteCommand;


import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.MainGameObject;
import spaceSurvival.model.common.V2d;

public class LeftCommand implements CommandGameObject{
	
	public LeftCommand() {}

	@Override
	public void execute(MainGameObject object) {
		V2d vel = object.getVelocity();
		
		if (vel.getX() >= -15) {
			object.setVelocity(vel.sum(new V2d(-1, 0)));
		}
		//System.out.println("Left " + object.toString());

		
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
