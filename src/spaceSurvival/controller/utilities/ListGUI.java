package spaceSurvival.controller.utilities;

import java.util.ArrayList;

public class ListGUI<X> extends ArrayList<X> {

    public ListGUI(){
        super();
    }

    public X lastElementOfList(){
        X x = null;
        try {
            x = super.get(super.size() - 1);
        } catch (NullPointerException e){
            System.err.println("element is null");
        }
        return x;
    }

    public X penultimateElementOfList(){
        X x = null;
        try {
            x = super.get(super.size() - 2);
        } catch (NullPointerException e){
            System.err.println("element is null");
        }
        return x;
    }


}
