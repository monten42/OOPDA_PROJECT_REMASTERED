package v1;

public class DuplicateFoundException extends Exception {
	
	public DuplicateFoundException(String message) {
		super(message);
		System.err.println("Another instance of of this item already exists");
		
	}

}
