package model.common;

public class Line {

    /** 
     * Accelerate the ship forward.
     * 
     * @param ship the controlled ship.
     */
    public P2d startPoint, endPoint;

    /** 
     * Get the start point of the line.
     * 
     * @return the starting point.
     */
    public P2d getStartPoint() {
        return this.startPoint;
    }

    /** 
     * Get the end point of the line.
     * 
     * @return the ending point.
     */
    public P2d getEndPoint() {
        return this.endPoint;
    }


    public Line(final P2d startPoint, final P2d endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    /** 
     * Get the length of the line.
     * 
     * @return the length of the line.
     */
    public double getLineLength() {
        return Math.sqrt(Math.pow(this.startPoint.getX() - this.endPoint.getX(), 2) + Math.pow(this.startPoint.getY() - this.endPoint.getY(), 2));
    }

    /** 
     * Returns a string that specifies the line.
     * 
     * @return return the string.
     */
    public String toString() {
        return "Line(StartPoint: " + this.startPoint.toString() + ", EndPoint: " + this.endPoint.toString() + ")";
    }

}
