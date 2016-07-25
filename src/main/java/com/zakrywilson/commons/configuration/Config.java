package com.zakrywilson.commons.configuration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
     * @param configFilePath the path to the configuration file to be set
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file
     */
    public Config(final String configFilePath) throws IOException, InvalidConfigurationException {
        initialize(configFilePath);
    }
    
    /**
     * Creates a new configuration containing a collection of data elements stored as <i>key</i>,
     * <i>value</i> entries.
     * 
     * @param is an input stream to the configuration file
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file
     */
    public Config(final InputStream is) throws IOException, InvalidConfigurationException {
        initialize(is);
    }

    /**
     * Gets a {@link Set} of the names of the data elements.
     *
     * @return a set of the data element names
     */
    public Set<String> getNames() {
        return elements.keySet();
    }

    /**
     * Gets a {@link Collection<String>} of the data element values.
     *
     * @return a collection of the data element names
     */
    public Collection<String> getElements() {
        return elements.values();
    }

    /**
     * Gets a {@literal Set<Map.Entry<String, String>>} of the data elements.
     *
     * @return an entry set of the data elements
     */
    public Set<Map.Entry<String, String>> getEntries() {
        return elements.entrySet();
    }

    /**
     * Gets the {@link String} representation of the data element value.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the element's value
     */
    public String getElement(final String name) {
        return elements.get(name);
    }

    /**
     * Gets the data element's value as a {@link boolean}. Acceptable values are "true", "false"
     * (not case-sensitive), <tt>1</tt>, and <tt>0</tt>. Any value other than the four will result
     * in a {@link TypeMismatchException}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link boolean}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public boolean getElementAsBoolean(final String name) throws TypeMismatchException {
        final String value = elements.get(name);
        if (value.equalsIgnoreCase("true") || value.equalsIgnoreCase("1")) {
            return true;
        }
        if (value.equalsIgnoreCase("false") || value.equalsIgnoreCase("0")) {
            return false;
        }
        throw new TypeMismatchException("Value is not a boolean: " + elements.get(name));
    }

    /**
     * Gets the element as a {@link byte}.
     * <p>
     * Acceptable values are those that are able to be parsed into a {@link byte}.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link byte}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public byte getElementAsByte(final String name) throws TypeMismatchException {
        try {
            return Byte.parseByte(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a byte: " + elements.get(name), e);
        }
    }

    /**
     * Gets the data element's value as a {@link char}.
     * <p>
     * Acceptable values must be one character in length. Anything less or more will result in a
     * {@link TypeMismatchException}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link char}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public char getElementAsChar(final String name) throws TypeMismatchException {
        final String value = elements.get(name);
        if (value.length() != 1) {
            throw new TypeMismatchException("Value is not a single character: " + value);
        }
        return value.charAt(0);
    }

    /**
     * Gets the element as a {@link short}.
     * <p>
     * Acceptable values are those that are able to be parsed into a {@link short}.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a {@link short}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public short getElementAsShort(final String name) throws TypeMismatchException {
        try {
            return Short.parseShort(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a short: " + elements.get(name), e);
        }
    }

    /**
     * Gets the element as an {@link int}.
     * <p>
     * Acceptable values are those that are able to be parsed into an {@link int}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link int}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public int getElementAsInt(final String name) throws TypeMismatchException {
        try {
            return Integer.parseInt(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not an integer: " + elements.get(name));
        }
    }

    /**
     * Gets the element as a {@link long}.
     * <p>
     * Acceptable values are those that are able to be parsed into a {@link long}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link long}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public long getElementAsLong(final String name) throws TypeMismatchException {
        try {
            return Long.parseLong(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a long: " + elements.get(name));
        }
    }

    /**
     * Gets the element as a {@link float}.
     * <p>
     * Acceptable values are those that are able to be parsed into a {@link float}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link float}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public float getElementAsFloat(final String name) throws TypeMismatchException {
        try {
            return Float.parseFloat(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a float: " + elements.get(name));
        }
    }

    /**
     * Gets the element as a {@link double}.
     * <p>
     * Acceptable values are those that are able to be parsed into a {@link double}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link double}
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *                               method's return value
     */
    public double getElementAsDouble(final String name) throws TypeMismatchException {
        try {
            return Double.parseDouble(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a double: " + elements.get(name));
        }
    }

    /**
     * Gets the element as a {@link File}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File}
     * @throws NullPointerException if the pathname argument is null
     */
    public File getElementAsFile(final String name) throws NullPointerException {
         return new File(name);
    }

    /**
     * Gets the element as a {@link File} and returns the instance if and only if the file passes the following
     * criteria. If the file does not pass the criteria, <tt>null</tt> is returned.
     * <p><ul>
     * <li>The file exists
     * <li>The file is a file (not a directory)
     * </ul></p>
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File} if it exists and is a file (not a directory). Otherwise,
     *         <tt>null</tt> is returned.
     * @throws NullPointerException if the pathname argument is null
     */
    public File getElementAsVerifiedFile(final String name) throws NullPointerException {
        File f = new File(name);
        if (!f.exists()) {
            return null;
        }
        if (!f.isFile()) {
            return null;
        }
        return f;
    }

    /**
     * Gets the element as a {@link File} and returns the instance if and only if the file passes the following
     * criteria. If the file does not pass the criteria, <tt>null</tt> is returned.
     * <p><ul>
     * <li>The file exists
     * <li>The file is a directory
     * </ul></p>
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File} if it exists and is a directory. Otherwise,
     *         <tt>null</tt> is returned.
     * @throws NullPointerException if the pathname argument is null
     */
    public File getElementAsVerifiedDirectory(final String name) throws NullPointerException {
        File d = new File(name);
        if (!d.exists()) {
            return null;
        }
        if (!d.isDirectory()) {
            return null;
        }
        return d;
    }

    /**
     * Gets the number of data elements in the configuration.
     *
     * @return the number of data elements in the configuration
     */
    public int size() {
        return elements.size();
    }

    /**
     * Initializes the configuration by parsing the configuration file and storing the data elements.
     *
     * @param configFilePath the path to the configuration file to be parsed
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file
     */
    private void initialize(final String configFilePath) throws IOException, InvalidConfigurationException {
        final ConfigFileParser parser = new ConfigFileParser(configFilePath);
        elements = parser.parseConfigFile();
    }
    
    /**
     * Initializes the configuration by parsing the configuration file and storing the data elements.
     *
     * @param is an input stream to the configuration file
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file
     */
    private void initialize(final InputStream is) throws IOException, InvalidConfigurationException {
        final ConfigFileParser parser = new ConfigFileParser(is);
        elements = parser.parseConfigFile();
    }

}
