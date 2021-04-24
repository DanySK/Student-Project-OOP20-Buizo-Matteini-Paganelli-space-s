package CommandProva;

import CommandProva.Caller.CallerAudio;


/**
 * A client class which uses the command controllers.
 * @author alberto paga
 *
 */
public class Client {
	
	CallerAudio manageAudio = new CallerAudio();
	MovementKeyListener manageMovement = new MovementKeyListener();
	
	public CallerAudio getManageAudio() {
		return this.manageAudio;
	}

	public void setManageAudio(CallerAudio manageAudio) {
		this.manageAudio = manageAudio;
	}


	public MovementKeyListener getManageMovement() {
		return this.manageMovement;
	}

	public void setManageMovement(MovementKeyListener manageMovement) {
		this.manageMovement = manageMovement;
	}
	
	
	public Client(){		
	}

	
}