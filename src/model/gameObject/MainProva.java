package model.gameObject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import model.gameObject.factories.AbstractFactoryGameObject;
import model.gameObject.factories.ConcreteFactoryAsteroid;
import model.gameObject.factories.ConcreteFactoryBoss;
import model.gameObject.factories.ConcreteFactoryChaseEnemy;
import utilities.DimensionScreen;
import view.spaceShip.SpaceShipView;

public class MainProva {

private JFrame frame = new JFrame();
	
	public MainProva() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, DimensionScreen.WIDTH_FULL_SCREEN, DimensionScreen.HEIGHT_FULL_SCREEN);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainProva();
		
		AbstractFactoryGameObject factoryAsteroid = new ConcreteFactoryAsteroid();
		AbstractFactoryGameObject factoryChaseEnemy = new ConcreteFactoryChaseEnemy();
		AbstractFactoryGameObject factoryBoss = new ConcreteFactoryBoss();
		
		List<AbstractGameObject> asteroidList = new ArrayList<AbstractGameObject>();
		List<AbstractGameObject> chaseEnemyList = new ArrayList<AbstractGameObject>();
		List<AbstractGameObject> bossList = new ArrayList<AbstractGameObject>();

		
		for (int i = 0; i < 2; i++) {
			asteroidList.add(factoryAsteroid.createObject());
			chaseEnemyList.add(factoryChaseEnemy.createObject());
			bossList.add(factoryBoss.createObject());
		}
		
		System.out.println(asteroidList.get(0));
		System.out.println(chaseEnemyList.get(0));
		System.out.println(bossList.get(0));
		
		new SpaceShipView();

	}

}
