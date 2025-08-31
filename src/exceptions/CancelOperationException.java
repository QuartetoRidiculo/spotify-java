package exceptions;

public class CancelOperationException extends RuntimeException {
    public CancelOperationException() {
        super("Operação cancelada pelo usuário.");
    }
}