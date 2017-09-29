package version1.dsa.exception;


public class QueueEmptyException extends RuntimeException {
	
	public QueueEmptyException(String err) {
		super(err);
	}	
}
