package spaceSurvival.model.common;

/**
 *
 * 2-dimensional point
 * objects are completely state-less
 *
 */
public class P2d implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public double x, y;

    public double getX() {
		return this.x;
	}
    
    public double getY() {
		return this.y;
	}



	public P2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public P2d sum(V2d v){
        return new P2d(this.x+v.x, this.y+v.y);
    }

    public V2d sub(P2d v){
        return new V2d(this.x-v.x, this.y-v.y);
    }

    public String toString(){
    return "Point2D(" + this.x + "," + this.y + ")";
    }

}
