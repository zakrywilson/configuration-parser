package com.aisolutions.program_i.configurationparser;

public class InvalidConfigurationException extends Exception {

    public InvalidConfigurationException() {
        super();
    }

    public InvalidConfigurationException(final String msg) {
        super(msg);
    }

    public InvalidConfigurationException(final Throwable t) {
        super(t);
    }

    public InvalidConfigurationException(final String msg, final Throwable t) {
        super(msg, t);
    }

}
