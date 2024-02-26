package execptions;

public class ElementNotFoundException extends RuntimeException {
    public ElementNotFoundException(String id) {
        super("Could not find element " + id);
    }
}
