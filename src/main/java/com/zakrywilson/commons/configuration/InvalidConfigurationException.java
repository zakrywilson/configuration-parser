package com.zakrywilson.commons.configuration;

/**
 * Exception to represent an invalid format in the configuration file.
 *
 * @author Zach Wilson
 */
public final class InvalidConfigurationException extends Exception {

    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = 7824728598992460425L;

    /**
     * Constructs a new exception with <tt>null</tt> as its detail message.
     */
    public InvalidConfigurationException() {}

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param msg the detail message. The detail message is saved for later retrieval by the
     *        {@link Throwable#getMessage()} method.
     */
    public InvalidConfigurationException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and
     * detail message of cause). This constructor is useful for exceptions that are little more
     * than wrappers for other throwable.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link Throwable#getCause()} method). (A <tt>null</tt>value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public InvalidConfigurationException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with cause is not automatically incorporated in this
     * exception's detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the
     *        {@link Throwable#getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link Throwable#getCause()} method). (A <tt>null</tt> value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public InvalidConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
