package model.GUI.settings;

public enum SkinSpaceShip {
    SPECIAL("spaceship/spaceship1.png"),
    STANDARD("spaceship/spaceship2.png"),
    DELUXE("spaceship/spaceship3.png"),
    NORMAL("spaceShip/spaceship4.png");

    private String path;

    private SkinSpaceShip(final String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
