package controller;

import model.command.concreteCommand.SpaceBarCommand;
import model.command.commandInterfaces.CommandGameObject;
import model.command.concreteCommand.DownCommand;
import model.command.concreteCommand.DownReleaseCommand;
import model.command.concreteCommand.LeftCommand;
import model.command.concreteCommand.LeftReleaseCommand;
import model.command.concreteCommand.RightCommand;
import model.command.concreteCommand.RightReleaseCommand;
import model.command.concreteCommand.RotateLeftCommand;
import model.command.concreteCommand.RotateRightCommand;
import model.command.concreteCommand.UpCommand;
import model.command.concreteCommand.UpReleaseCommand;
import model.gameObject.MainGameObject;
import utilities.CommandType;

public class CallerCommand {

	private final CommandGameObject cmdLeft;
	private final CommandGameObject cmdUp;
	private final CommandGameObject cmdRight;
	private final CommandGameObject cmdDown;
	
	private final CommandGameObject cmdReleaseLeft;
	private final CommandGameObject cmdReleaseUp;
	private final CommandGameObject cmdReleaseRight;
	private final CommandGameObject cmdReleaseDown;
	
	private final CommandGameObject cmdRotateLeft;
	private final CommandGameObject cmdRotateRight;
	
	private final SpaceBarCommand cmdShot;

	private final MainGameObject ship;
	
	
	public CallerCommand(MainGameObject ship) {
		this.cmdLeft  = new LeftCommand();
		this.cmdUp    = new UpCommand();
		this.cmdRight = new RightCommand();
		this.cmdDown  = new DownCommand();
		
		this.cmdReleaseLeft  = new LeftReleaseCommand();
		this.cmdReleaseUp    = new UpReleaseCommand();
		this.cmdReleaseRight = new RightReleaseCommand();
		this.cmdReleaseDown  = new DownReleaseCommand();
		
		this.cmdRotateLeft   = new RotateLeftCommand();
		this.cmdRotateRight  = new RotateRightCommand();
		
		//aggiunto comando per la barra spaziatrice
		this.cmdShot  = new SpaceBarCommand();

		this.ship = ship;
	}
	
	public void execute(CommandType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdLeft.execute(ship);
			 break;
		 case KEY_RIGHT:
			 cmdRight.execute(ship);
			 break;
		 case KEY_UP:
			 cmdUp.execute(ship);
			 break;
		 case KEY_DOWN:
			 cmdDown.execute(ship);
			 break;		 
		 case KEY_ROTATE_LEFT:
			 cmdRotateLeft.execute(ship);
			 break;
		 case KEY_ROTATE_RIGHT:
			 cmdRotateRight.execute(ship);
			 break;
		 case KEY_SPACE_BAR:
			 cmdShot.execute(ship);
			 
			 break;
		 }
	}
	
	public void release(CommandType cmd) {
		 switch(cmd) {
		 case KEY_LEFT:
			 cmdReleaseLeft.execute(ship);
			 break;
		 case KEY_RIGHT:
			 cmdReleaseRight.execute(ship);
			 break;
		 case KEY_UP:
			 cmdReleaseUp.execute(ship);
			 break;
		 case KEY_DOWN:
			 cmdReleaseDown.execute(ship);
			 break;
		default:
			break;
		 }
	}
	
	
}
