package exceptions;

public class CancelOperation extends RuntimeException {
    public CancelOperation() {
        super("Operação cancelada pelo usuário.");
    }
}