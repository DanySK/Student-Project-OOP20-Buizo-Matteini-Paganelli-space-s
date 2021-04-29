package sound;
import sound.category.SoundEffect;
import sound.category.SoundLoop;
import utilities.SoundPath;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import CommandProva.Caller.CallerAudio;
import CommandProva.CmdType.CmdAudioType;

import java.awt.*;
import java.awt.event.ActionListener;


public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JSlider jslider;
    private final static int SIZE = 5;
    //private final Logics logic;
    
    
    //SoundObserver observerEffects = new SoundEffect();
    //SoundObserver observerLoop = new SoundLoop();
    
    private CallerAudio telecomando;

    
    
    public GUI() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*SIZE, 100*SIZE);
        
        JPanel panel = new JPanel(new GridLayout(SIZE, SIZE));
        this.getContentPane().add(BorderLayout.CENTER, panel);
        
        this.jslider = new JSlider();
        
        //this.logic = new LogicsImpl();

        
        ActionListener toggleLoopSound = (e)->{
            System.out.println("Faccio partire il suono " + e.getActionCommand());
            
            

            
            
    		//observerLoop.update(SoundPath.valueOf(e.getActionCommand()));
            this.telecomando = new CallerAudio(new SoundLoop(SoundPath.valueOf(e.getActionCommand())));
            this.telecomando.execute(CmdAudioType.AUDIO_ON);
        };
        
        ActionListener toggleEffectSound = (e)->{
            System.out.println("Faccio partire il suono " + e.getActionCommand());
            
    		//observerEffects.update(SoundPath.valueOf(e.getActionCommand()));
            this.telecomando = new CallerAudio(new SoundEffect(SoundPath.valueOf(e.getActionCommand())));
            this.telecomando.execute(CmdAudioType.AUDIO_ON);
        };
        
 
        //jslider.setMinorTickSpacing(10); 
        //jslider.setSnapToTicks(true);
             
        jslider.addChangeListener(new ChangeListener() {
        
        	//Integer currentVolume = 50;
        	//Integer diff = 0;
			public void stateChanged(ChangeEvent event) { 	
				
				telecomando.changeVolume(jslider.getValue());
        		 
//        		  List<Integer> accepted = Arrays.asList(0,10,20,30,40,50,60,70,80,90,100);
//        		  Integer sValue = jslider.getValue();
//        		
//        		  
//        		  if(accepted.contains(sValue) && currentVolume != sValue) {
//        			  //Integer diff = (sValue + 50)/100;
//        			  diff = -(currentVolume - sValue)/10;
//        			  if(diff > 0) {
//        				  telecomando.execute(CmdAudioType.TURN_UP_VOLUME);
//        			  }
//        			  else {
//        				  telecomando.execute(CmdAudioType.TURN_DOWN_VOLUME);
//        			  }
//
//        			  currentVolume = sValue;
//        			  System.out.println(sValue);
//        			  
//        		  }
	  
        	  }

			
        });

	    final JButton jbMenu = new JButton("GAME_SOUND");
	    final JButton jbGame = new JButton("MENU_SOUND");
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
