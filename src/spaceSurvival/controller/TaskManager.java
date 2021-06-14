package spaceSurvival.controller;

import javax.swing.SwingUtilities;

import jdk.javadoc.internal.tool.Start;
import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.model.EngineMalaLoop;

public class TaskManager {
    private final Thread taskGame;
    private final Thread taskGUI;
    
    private EngineMalaLoop engineLoop;
    private CtrlGUI controlGUI;
    
    public TaskManager(final CtrlGUI controlGUI, final EngineMalaLoop engineLoop) {
//        this.controlGUI = controlGUI;
//        this.engineLoop = engineLoop;
        
        
        
        this.taskGUI = new Thread(TaskManager.this::runGUI);
        this.taskGame = new Thread(TaskManager.this::runLoop);
        
    }

    public void runGUI() {
       while(true) {
           SwingUtilities.invokeLater(() -> {
               TaskManager.this.controlGUI.startGUI();
           });
       }
    }
    
    public void runLoop() {
        
    }
}
