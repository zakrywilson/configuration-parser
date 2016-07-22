package com.zakrywilson.commons.configuration;

/**
 * Represents an inability to parse a <tt>String</tt> due to a type mismatch.
 *
 * @author Zach Wilson
 */
public final class TypeMismatchException extends Exception {

    /**
     * Constructs a new runtime exception with null as its detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to
     * {@link Throwable#initCause(java.lang.Throwable)}.
     */
    public TypeMismatchException() {
        super();
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to
     * {@link Throwable#initCause(java.lang.Throwable)}.
     *
     * @param msg the detail message. The detail message is saved for later retrieval by the
     *            {@link Throwable#getMessage()} method.
     */
    public TypeMismatchException(final String msg) {
        super(msg);
    }

    /**
     * Constructs a new runtime exception with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and
     * detail message of cause). This constructor is useful for runtime exceptions that are
     * little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link Throwable#getCause()} method). (A <tt>null</tt> value is permitted, and
     *              indicates that the cause is nonexistent or unknown.)
     */
    public TypeMismatchException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with cause is not automatically incorporated in this
     * runtime exception's detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the
     *            {@link Throwable#getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link Throwable#getCause()} method). (A <tt>null</tt> value is permitted, and
     *              indicates that the cause is nonexistent or unknown.)
     */
    public TypeMismatchException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
