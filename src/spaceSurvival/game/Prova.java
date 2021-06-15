package spaceSurvival.game;

import spaceSurvival.view.game.concrete.GUIGameConcrete;
import spaceSurvival.view.help.concrete.GUIHelpConcrete;
import spaceSurvival.view.pause.concrete.GUIPauseConcrete;
import spaceSurvival.view.settings.concrete.GUISettingsConcrete;
import spaceSurvival.view.sound.concrete.GUISoundConcrete;

public class Prova extends GUIHelpConcrete{
    
    public Prova() {
        super();
        int nbThreads =  Thread.getAllStackTraces().keySet().size();
        
        System.out.println("Numero dei thread current -> " + nbThreads);
    }

    
    public static void main(String[] args) {
        new Prova();
    }
}
