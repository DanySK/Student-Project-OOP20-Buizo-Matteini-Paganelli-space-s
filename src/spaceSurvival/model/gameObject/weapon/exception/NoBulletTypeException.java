package spaceSurvival.model.gameObject.weapon.exception;

public class NoBulletTypeException extends RuntimeException {

	private String message;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBulletTypeException(final String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + message;
	}
}
