package CommandProva.ConcreteCommandMovement;

import java.awt.Graphics;

import CommandProva.CommandInterfaces.CommandMovement;
import CommandProva.graphics.GraphicsComponent;
import CommandProva.graphics.ShipGraphicsComponent;
import CommandProva.graphics.SwingGraphics;
import CommandProva.model.GameObject;
import common.V2d;

public class RotateLeftCommand implements CommandMovement{
	
	public RotateLeftCommand() {}

	@Override
	public void execute(GameObject ship) {
		System.out.println("Rotate Left");
		//ship.getGraphic().getClass().cast(ship.getGraphic());
		
		//System.out.println()
		
		//ship.updateGraphics(ship.getGraphic());
		
		//Graphics graph = ship.getGraphic();
		ShipGraphicsComponent graph;// = new ShipGraphicsComponent();
		//graph = (ShipGraphicsComponent) ship.getGraphic();
		
		graph = (ShipGraphicsComponent) ship.getGraphic();
		//graph.getG2().rotate(15);
		//graph.update(ship, g);
		
		ship.setGraphic((GraphicsComponent) graph);
		
		
		//graph.update(ship, new ShipGraphicsComponent());
		
		
		
		//ship.getGraphic().update(ship, );
		


		
		
	}
	
}