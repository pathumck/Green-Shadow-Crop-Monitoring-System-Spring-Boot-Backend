package lk.ijse.greenshadow.exception;

public class DataPersistException extends RuntimeException {
    public DataPersistException() {
    }

    public DataPersistException(String message) {
        super(message);
    }

    public DataPersistException(String message, Throwable cause) {
        super(message, cause);
    }
}