package model.environment;

public class Environment {

    private Integer[][] gameGrid;

    
    public Environment(final int width, final int height) {
        gameGrid = new Integer[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gameGrid[i][j] = 0;
            }
        }
    }

    
    public static void main(String[] args){
        
        Environment environment = new Environment(10, 20);
        
    }
}
