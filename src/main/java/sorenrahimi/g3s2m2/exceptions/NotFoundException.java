package sorenrahimi.g3s2m2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id){
        super(id + " non trovato!");
    }
}
