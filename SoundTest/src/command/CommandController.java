package command;

/**
 * A command controller  which should be implemented by all controllers
 * @author alberto paga
 *
 */
public interface CommandController{
	public void execute(String command);
	public boolean canHandle(String command);
}
