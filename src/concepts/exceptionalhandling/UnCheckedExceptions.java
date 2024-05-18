package concepts.exceptionalhandling;

public class UnCheckedExceptions extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7909838767326287274L;

	public UnCheckedExceptions() {
		super();
	}
	
	public UnCheckedExceptions(String s) {
		super(s);
	}
	
	public UnCheckedExceptions(Throwable e) {
		super(e);
	}
	
	public UnCheckedExceptions(String message,Throwable e) {
		super(message,e);
	}
	
}
