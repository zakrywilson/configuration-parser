package com.aisolutions.program_i.configurationparser;

public class TypeMismatchException extends RuntimeException {

    public TypeMismatchException() {
        super();
    }

    public TypeMismatchException(final String msg) {
        super(msg);
    }

    public TypeMismatchException(final Throwable t) {
        super(t);
    }

    public TypeMismatchException(final String msg, final Throwable t) {
        super(msg, t);
    }

}
