package utilities;

public enum SkinSpaceShip {
    STANDARD("spaceship/spaceShip.png"),
    DELUXE("spaceship/starShip.png"),
    PRIME("spaceship/maxShip.png");

    private String path;

    private SkinSpaceShip(final String path){
        this.path = path;
    }

    public String getPath(){
        return this.path;
    }
}
