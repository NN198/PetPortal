package pets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ResourceNotFoundException class will be called in cases when the id of the owner, pet and vet
 * is not available in the database or when it is not registered
 *
 * @author Noella Noronha
 * @author Arpit Dubey
 * @author Harshit Jain
 * @author Nidhi Dewangan
 * @author Ankita Hundet
 */


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}
