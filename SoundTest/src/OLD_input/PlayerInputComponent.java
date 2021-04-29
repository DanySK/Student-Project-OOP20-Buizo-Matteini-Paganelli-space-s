package OLD_input;

import common.V2d;
import CommandProva.model.*;

public class PlayerInputComponent implements InputComponent {

	public void update(GameObject ball, InputController ctrl){
		if (ctrl.isMoveUp()){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(0,1).mul(speed));
		} else if (ctrl.isMoveDown()){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(0,-1).mul(speed));
		} else if (ctrl.isMoveLeft()){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(-1,0).mul(speed));			
		} else if (ctrl.isMoveRight()){
			double speed = ball.getCurrentVel().module();
			ball.setVel(new V2d(1,0).mul(speed));			
		}
	
	}

}
