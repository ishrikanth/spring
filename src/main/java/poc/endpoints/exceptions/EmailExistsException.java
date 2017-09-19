package poc.endpoints.exceptions;

/**
 * Created by shrikanth on 27/7/17.
 */
public class EmailExistsException extends RuntimeException {
    public EmailExistsException() {
        super();
    }
    public EmailExistsException(String message){super(message);}
}
