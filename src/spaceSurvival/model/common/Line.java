package spaceSurvival.model.common;

public class Line {


    public P2d startPoint, endPoint;

    public P2d getStartPoint() {
        return this.startPoint;
    }

    public P2d getEndPoint() {
        return this.endPoint;
    }

    public P2d getY() {
        return this.endPoint;
    }

    public Line(final P2d startPoint, final P2d endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        }


    public double getLineLength() {
        return Math.sqrt(Math.pow(this.startPoint.getX() - this.endPoint.getX(), 2) + Math.pow(this.startPoint.getY() - this.endPoint.getY(), 2));
    }

    @Override
    public String toString() {
        return "Line(StartPoint: " + this.startPoint.toString() + ", EndPoint: " + this.endPoint.toString() + ")";
    }

}
