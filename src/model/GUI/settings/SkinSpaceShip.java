package model.GUI.settings;

public enum SkinSpaceShip {
    STANDARD("spaceship/spaceship_04.png"),
    DELUXE("spaceship/spaceship_02.png"),
    NORMAL("spaceship/spaceship_06.png"),
    SPECIAL("spaceship/spaceship_07.png"),
    GNEGNE("spaceship/spaceship_09.png"),
    SURPRISE("spaceship/spaceship_10.png"),
    MALA("spaceship/spaceship_15.png"),
    PRIME("spaceship/spaceship_16.png"),
    UNDEFINE("spaceship/spaceship_20.png");

    private String path;

    private SkinSpaceShip(final String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
