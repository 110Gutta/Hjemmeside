package exceptions;

/**
 *
 * @author nilf
 */
public class MemberNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MemberNotFoundException(String msg) {
		super(msg);
	}
}