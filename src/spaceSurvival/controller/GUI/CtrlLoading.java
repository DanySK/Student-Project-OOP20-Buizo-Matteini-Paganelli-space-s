package spaceSurvival.controller.GUI;

import spaceSurvival.controller.GUI.command.SwitchGUI;
import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.loading.EngineLoading;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.GUI.Loading.GUILoading;


public class CtrlLoading extends Thread implements ControllerGUI{
    private final GUILoading gui;
    private final EngineLoading engine;

    private final SwitchGUI switchGUI;

    public CtrlLoading(final EngineLoading engine, final GUILoading gui){
        this.engine = engine;
        this.gui = gui;

        this.switchGUI = new SwitchGUI(this.engine, this.gui);
        this.turn(Visibility.VISIBLE);
    }


    @Override
    public void run() {
        super.run();

        while(!this.engine.isLoad()){
            this.engine.incrLoading();
            this.gui.setLoading(this.engine.getLoading() / 25);

            if(this.engine.getLoading() >= 2500){
                this.engine.load();
            }

            this.sleep(1);
        }

    }

    public boolean isLoad(){
        return this.engine.isLoad();
    }

    private void sleep(final int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public IdGUI getIdGUI(){
        return this.engine.getId();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }
}
