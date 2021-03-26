package model.environment;

public class Point2D {

    private int x;
    private int y;
    
    public Point2D(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point2D(final Point2D point) {
        this.x = point.x;
        this.y = point.y;
    }
    
    public void setX(final int newX) {
        this.x = newX;
    }
    
    public void setY(final int newY) {
        this.y = newY;
    }
    
    public void setPoint(final int newX, final int newY) {
        this.x = newX;
        this.y = newY;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public Point2D getPoint() {
        return this;
    }

    public String toString() {
        return "Point2D {x : " + this.getX() + ", y : " + this.getY() + "}";
    }
}
