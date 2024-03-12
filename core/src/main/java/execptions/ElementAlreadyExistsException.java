package execptions;

public class ElementAlreadyExistsException extends RuntimeException {
    public ElementAlreadyExistsException(String id) {
        super("Element already exists " + id);
    }
}
