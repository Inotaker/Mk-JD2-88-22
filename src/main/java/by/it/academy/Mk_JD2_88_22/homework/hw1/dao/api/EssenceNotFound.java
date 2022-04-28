package by.it.academy.Mk_JD2_88_22.homework.hw1.dao.api;

public class EssenceNotFound extends RuntimeException {

    public EssenceNotFound() {
    }

    public EssenceNotFound(String message) {
        super(message);
    }

    public EssenceNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public EssenceNotFound(Throwable cause) {
        super(cause);
    }

    public EssenceNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
