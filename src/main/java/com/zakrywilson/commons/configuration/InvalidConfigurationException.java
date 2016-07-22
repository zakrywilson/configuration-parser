package com.zakrywilson.commons.configuration;

/**
 * Exception to represent an invalid format in the configuration file.
 *
 * @author Zach Wilson
 */
public final class InvalidConfigurationException extends Exception {

    /**
     * Constructs a new exception with null as its detail message. The cause is not initialized,
     * and may subsequently be initialized by a call to Throwable.initCause(java.lang.Throwable).
     */
    public InvalidConfigurationException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized,
     * and may subsequently be initialized by a call to Throwable.initCause(java.lang.Throwable).
     *
     * @param msg the detail message. The detail message is saved for later retrieval by the
     *            {@linkThrowable#getMessage()} method
     */
    public InvalidConfigurationException(final String msg) {
        super(msg);
    }

    /**
     * Constructs a new exception with the specified cause and a detail message of
     * <tt>(cause==null ? null : cause.toString())</tt> (which typically contains the class and
     * detail message of cause). This constructor is useful for exceptions that are little more
     * than wrappers for other throwables (for example, {@linkPrivilegedActionException)}.
     *
     * @param cause the cause (which is saved for later retrieval by the {@linkThrowable#getCause()}
     *              method). (A <tt>null</tt>value is permitted, and indicates that the cause is
     *              nonexistent or unknown.)
     */
    public InvalidConfigurationException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with cause is not automatically incorporated in this
     * exception's detail message.
     *
     * @param msg the detail message (which is saved for later retrieval by the
     *            {@linkThrowable#getMessage()} method)
     * @param cause the cause (which is saved for later retrieval by the {@linkThrowable#getCause()}
     *              method). (A <tt>null</tt> value is permitted, and indicates that the cause is
     *              nonexistent or unknown.)
     */
    public InvalidConfigurationException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
