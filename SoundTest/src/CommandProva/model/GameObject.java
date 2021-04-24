package CommandProva.model;

import CommandProva.graphics.*;
import CommandProva.input.*;
import common.*;

import physics.*;

public class GameObject {

	public static enum Type { BALL, PICKABLE_OBJ }

	private Type type;
	private P2d position;
	private V2d velocity;
	private BoundingWall bbox;
	
	private InputComponent input;
	private GraphicsComponent graphic;
	private PhysicsComponent physics;
	
	public GameObject(Type type, P2d pos, V2d vel, BoundingWall box, InputComponent input, GraphicsComponent graph, PhysicsComponent phys){
		this.type = type;
		this.position = pos;
		this.velocity = vel;
		this.bbox = box;
		this.input = input;
		this.graphic = graph;
		this.physics = phys;
	}
	
	public Type getType(){
		return type;
	}
	
	public void setPos(P2d pos){
		this.position = pos;
	}

	public void setVel(V2d vel){
		this.velocity = vel;
	}

	public void flipVelOnY(){
		this.velocity = new V2d(velocity.x, -velocity.y);
	}

	public void flipVelOnX(){
		this.velocity = new V2d(-velocity.x, velocity.y);
	}
	
	public BoundingWall getBBox(){
		return bbox;
	}
	
	public P2d getCurrentPos(){
		return position;
	}
	
	public V2d getCurrentVel(){
		return velocity;
	}

	public void updateInput(InputController c){
		input.update(this, c);
	}

	public void updatePhysics(int dt, World w){
		physics.update(dt, this, w);
	}
	
	public void updateGraphics(Graphics g){
		graphic.update(this, g);
	}
	
}
