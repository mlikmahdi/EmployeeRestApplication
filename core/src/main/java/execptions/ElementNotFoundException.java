package execptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(Long id) {
        super("Could not find element " + id);
    }
}
