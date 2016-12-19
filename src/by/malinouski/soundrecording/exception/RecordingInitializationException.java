package by.malinouski.soundrecording.exception;

public class RecordingInitializationException extends Exception {

    public RecordingInitializationException() {
    }

    public RecordingInitializationException(String message) {
        super(message);
    }

    public RecordingInitializationException(Throwable cause) {
        super(cause);
    }

    public RecordingInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordingInitializationException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
