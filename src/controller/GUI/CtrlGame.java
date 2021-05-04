package controller.GUI;

import model.GUI.EngineGUI;
import model.GUI.game.EngineGame;
import view.GUI.GUI;
import view.GUI.game.GUIGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CtrlGame implements ControllerGUI{
    private final EngineGame engine;
    private final GUIGame gui;


    public CtrlGame(final EngineGame engine, final GUIGame gui){
        this.engine = engine;
        this.gui = gui;

        this.gui.addKeyListenerSpaceship(this.getKeyListener());

        this.init();
    }

    private void init(){
        this.gui.setId(this.engine.getId());
        this.gui.setVisible(this.engine.isVisible());
    }

    private KeyListener getKeyListener(){
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }
}
