package game;

import view.help.concrete.GUIHelpConcrete;

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
