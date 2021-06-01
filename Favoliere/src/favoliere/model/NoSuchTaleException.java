package favoliere.model;

public class NoSuchTaleException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSuchTaleException() {
		super();
	}

	public NoSuchTaleException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchTaleException(String message) {
		super(message);
	}

	public NoSuchTaleException(Throwable cause) {
		super(cause);
	}

}
