package concepts.exceptionalhandling;

public class CheckedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CheckedException() {
        super();
    }
	
	public CheckedException(String message){
		super(message);
	}
	
	public CheckedException(Throwable e) {
		super(e);
	}
	
	public CheckedException(String message,Throwable e) {
		super(message,e);
	}
	
	
	
}
