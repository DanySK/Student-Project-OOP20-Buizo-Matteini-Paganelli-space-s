package command;

import input.MyKeyListener;

/**
 * A client class which uses the command controllers.
 * @author alberto paga
 *
 */
public class Client {

	private MyKeyListener myKeyListener;
	
	
	public Client(MyKeyListener myKeyListener){
		this.myKeyListener = myKeyListener;
	}
	
	public void startGame(){
		
		
//		do{
//		//String command = (String)JOptionPane.showInputDialog(null, "Give command", "Command Controls", JOptionPane.INFORMATION_MESSAGE, null, this.commands, this.commands[0]);
//		//joystick.execute(command);
//		
//		}while(true);
	}
	
	public MyKeyListener getKeyListener() {
		return this.myKeyListener;
	}

}
