package model.sound;
import utilities.SoundType;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JSlider jslider;
    private final static int SIZE = 5;
    private final Logics logic;
    
    
    SoundObserver observerEffects = new SoundEffect();
    SoundObserver observerLoop = new SoundLoop();

    
    
    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        this.getContentPane().add(BorderLayout.CENTER, panel);
        
        this.jslider = new JSlider();
        
        this.logic = new LogicsImpl();
        
        
//        ActionListener al = (e)->{
//            System.out.println("Faccio partire il suono " + e.getActionCommand());
//            
//            //CHIARAMENTE DA RIFATTORIZZARE, GLI ENUM DOPO 2 SONO GLI EFFECT E NON I LOOP
//            //NON AVREMO PROBLEMI CON INTERFACE CHE ACCETTA SIA LOOP CHE EFFECT
//           if(SoundType.valueOf(e.getActionCommand()).ordinal() > 2){
//
//                if(this.logic.getSoundEffect().isPlaying()) {
//                	this.logic.getSoundEffect().stopClip();
//                }
//                this.logic.getSoundEffect().setSoundType(SoundType.valueOf(e.getActionCommand()));
//                this.logic.getSoundEffect().startClip();	
//                System.out.println("EFFECT");
//            }
//            else
//            {
//                if(this.logic.getSoundLoop().isPlaying()) {
//            	this.logic.getSoundLoop().stopClip();
//              	}
//                this.logic.getSoundLoop().setSoundType(SoundType.valueOf(e.getActionCommand()));
//                this.logic.getSoundLoop().startClip();	
//                System.out.println("LOOP");
//            }
//          
//        };
        

        
        ActionListener toggleLoopSound = (e)->{
            System.out.println("Faccio partire il suono " + e.getActionCommand());

    		observerLoop.update(SoundType.valueOf(e.getActionCommand()));
        };
        
        ActionListener toggleEffectSound = (e)->{
            System.out.println("Faccio partire il suono " + e.getActionCommand());
            
    		observerEffects.update(SoundType.valueOf(e.getActionCommand()));		
        };
               
        jslider.addChangeListener(new ChangeListener() {
        	  public void stateChanged(ChangeEvent event) { 	    
        		  System.out.println(jslider.getValue());
        		  logic.changeVolume(jslider.getValue());
        	  }
        });

	    final JButton jbMenu = new JButton("MENU_SOUND");
	    final JButton jbGame = new JButton("GAME_SOUND");
	    final JButton jbShoot = new JButton("SHOOT");
	    final JButton jbMovement = new JButton("MOVEMENT");
	    final JButton jbLifeUp = new JButton("LIFE_UP");
	    final JButton jbLifeDown = new JButton("LIFE_DOWN");
	    
	    jbMenu.addActionListener(toggleLoopSound);
	    jbGame.addActionListener(toggleLoopSound);
	    jbShoot.addActionListener(toggleEffectSound);
	    jbMovement.addActionListener(toggleEffectSound);
	    jbLifeUp.addActionListener(toggleEffectSound);
	    jbLifeDown.addActionListener(toggleEffectSound);
	    
	    
	    panel.add(jbMenu);
	    panel.add(jbGame);
	    panel.add(jbShoot);
	    panel.add(jbMovement);
	    panel.add(jbLifeUp);
	    panel.add(jbLifeDown);
	    
	    panel.add(jslider);


        this.setVisible(true);
    }

    
}
