package v1;

/**
 * Custom Exception
 * The exception is thrown when an instance of a file already exists when trying to make a new one. The exception is thrown 
 * @author team Cyan
 *
 */
public class DuplicateFoundException extends Exception {
	
	public DuplicateFoundException(String message) {
		super(message);
		System.err.println("Another instance of of this item already exists");
		
	}

}
