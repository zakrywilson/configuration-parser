package com.zakrywilson.commons.configuration;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Represents the data for a single configuration file.
 *
 * @author Zach Wilson
 */
public final class Config {

    /**
     * A collection of all configuration data points.
     */
    private Map<String, String> elements;

    /**
     * Creates a new configuration containing a collection of data elements stored as <i>key</i>,
     * <i>value</i> entries.
     *
     * @param configFilePath the path to the configuration file to be set.
     * @throws IOException if an I/O error should occur.
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file.
     */
    public Config(final String configFilePath) throws IOException, InvalidConfigurationException {
        initialize(configFilePath);
    }

    /**
     * Gets a {@link Set} of the names of the data elements.
     *
     * @return a set of the data element names.
     */
    public Set<String> getNames() {
        return elements.keySet();
    }

    /**
     * Gets a {@link Collection<String>} of the data element values.
     *
     * @return a collection of the data element names.
     */
    public Collection<String> getElements() {
        return elements.values();
    }

    /**
     * Gets a {@link Set<Map.java.util.Map.Entry<String, String>>} of the data elements.
     *
     * @return an entry set of the data elements.
     */
    public Set<Map.Entry<String, String>> getEntries() {
        return elements.entrySet();
    }

    /**
     * Gets the {@link String} representation of the data element value.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the element's value.
     */
    public String getElement(final String name) {
        return elements.get(name);
    }

    /**
     * Gets the data element's value as a {@link char}.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link char}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public char getElementAsChar(final String name) throws TypeMismatchException {
        final String value = elements.get(name);
        if (value.length() != 1) {
            throw new TypeMismatchException("Value is not a single character: " + value);
        }
        return value.charAt(0);
    }

    /**
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link short}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public short getElementAsShort(final String name) throws TypeMismatchException {
        try {
            return Short.parseShort(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a short: " + elements.get(name), e);
        }
    }

    /**
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link byte}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public byte getElementAsByte(final String name) throws TypeMismatchException {
        try {
            return Byte.parseByte(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a byte: " + elements.get(name), e);
        }
    }

    /**
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link int}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public int getElementAsInteger(final String name) throws TypeMismatchException {
        try {
            return Integer.parseInt(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not an integer: " + elements.get(name));
        }
    }

    /**
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link float}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public float getElementAsFloat(final String name) throws TypeMismatchException {
        try {
            return Float.parseFloat(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a float: " + elements.get(name));
        }
    }

    /**
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link double}.
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value.
     */
    public double getElementAsDouble(final String name) throws TypeMismatchException {
        try {
            return Double.parseDouble(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a double: " + elements.get(name));
        }
    }

    /**
     * Gets the number of data elements in the configuration.
     *
     * @return the number of data elements in the configuration.
     */
    public int size() {
        return elements.size();
    }

    /**
     * Initializes the configuration by parsing the configuration file and storing the data elements.
     *
     * @param configFilePath the path to the configuration file to be parsed.
     * @throws IOException if an I/O error should occur.
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file.
     */
    private void initialize(final String configFilePath) throws IOException, InvalidConfigurationException {
        final ConfigFileParser parser = new ConfigFileParser(configFilePath);
        elements = parser.parseConfigFile();
    }

}
