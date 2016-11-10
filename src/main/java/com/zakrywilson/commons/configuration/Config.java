package com.zakrywilson.commons.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a
     *         file
     */
    public Config(String configFilePath) throws IOException, InvalidConfigurationException {
        initialize(configFilePath);
    }

    /**
     * Creates a new configuration containing a collection of data elements stored as <i>key</i>,
     * <i>value</i> entries.
     *
     * @param is an input stream to the configuration file
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a
     *         file
     */
    public Config(InputStream is) throws IOException, InvalidConfigurationException {
        initialize(is);
    }

    /**
     * Gets a {@link List<String>} of the names of the data elements.
     *
     * @return a set of the data element names
     */
    public List<String> getNames() {
        return (List<String>) elements.keySet();
    }

    /**
     * Gets a {@link List<String>} of the data element values.
     *
     * @return a collection of the data element names
     */
    public List<String> getElements() {
        return (List<String>) elements.values();
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
     * @return the element's value or <tt>null</tt> if no element is found
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public String getString(String name) throws IllegalArgumentException {
        return getByName(name);
    }

    /**
     * Gets the data element's value as a <tt>boolean</tt>. Acceptable values are "true", "false"
     * (not case-sensitive), <tt>1</tt>, and <tt>0</tt>. Any value other than the four will result
     * in a {@link TypeMismatchException}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>boolean</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public boolean getBoolean(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        if (element.equalsIgnoreCase("true") || element.equalsIgnoreCase("1")) {
            return true;
        }
        if (element.equalsIgnoreCase("false") || element.equalsIgnoreCase("0")) {
            return false;
        }
        throw new TypeMismatchException("Value is not a boolean: " + element);
    }

    /**
     * Gets the element as a <tt>byte</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into a <tt>byte</tt>.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a <tt>byte</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public byte getByte(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Byte.parseByte(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a byte: " + element, e);
        }
    }

    /**
     * Gets the data element's value as a <tt>char</tt>.
     * <p>
     * Acceptable values must be one character in length. Anything less or more will result in a
     * {@link TypeMismatchException}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>char</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public char getChar(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        if (element.length() != 1) {
            throw new TypeMismatchException("Value is not a single character: " + element);
        }
        return element.charAt(0);
    }

    /**
     * Gets the element as a <tt>short</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into a <tt>short</tt>.
     *
     * @param name the name of the element to be used to obtain its value.
     * @return the value of the data element as a <tt>short</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public short getShort(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Short.parseShort(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a short: " + element, e);
        }
    }

    /**
     * Gets the element as an <tt>int</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into an <tt>int</tt>.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>int</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public int getInt(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not an integer: " + element, e);
        }
    }

    /**
     * Gets the element as a <tt>long</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into a <tt>long</tt>.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>long</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public long getLong(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Long.parseLong(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a long: " + element, e);
        }
    }

    /**
     * Gets the element as a <tt>float</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into a <tt>float</tt>.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>float</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public float getFloat(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Float.parseFloat(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a float: " + element, e);
        }
    }

    /**
     * Gets the element as a <tt>double</tt>.
     * <p>
     * Acceptable values are those that are able to be parsed into a <tt>double</tt>.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a <tt>double</tt>
     * @throws TypeMismatchException if the type of the data element value does not match with this
     *         method's return value
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public double getDouble(String name) throws TypeMismatchException, IllegalArgumentException {
        String element = getByName(name);
        try {
            return Double.parseDouble(element);
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a double: " + element, e);
        }
    }

    /**
     * Gets the element as a {@link File}.
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File}
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public File getFile(String name) throws IllegalArgumentException {
        String element = getByName(name);
        return new File(element);
    }

    /**
     * Gets the element as a {@link File} and returns the instance if and only if the file passes
     * the following criteria. If the file does not pass the criteria, <tt>null</tt> is returned.
     * <p>
     * <ul>
     *   <li>The file exists
     *   <li>The file is a file (not a directory)
     * </ul>
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File} if it exists and is a file (not a
     *         directory). Otherwise, <tt>null</tt> is returned
     * @throws FileNotFoundException if file does not exist or it is a directory
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public File getVerifiedFile(String name) throws FileNotFoundException, IllegalArgumentException {
        String element = getByName(name);
        File f = new File(element);
        if (!f.exists()) {
            throw new FileNotFoundException(String.format("File does not exist for name '%s': %s",
                                                          name, element));
        }
        if (f.isDirectory()) {
            throw new FileNotFoundException("File is a directory: " + f);
        }
        return f;
    }

    /**
     * Gets the element as a {@link File} and returns the instance if and only if the file passes
     * the following criteria. If the file does not pass the criteria, <tt>null</tt> is returned.
     * <p>
     * <ul>
     *   <li>The file exists
     *   <li>The file is a directory
     * </ul>
     *
     * @param name the name of the element to be used to obtain its value
     * @return the value of the data element as a {@link File} if it exists and is a directory
     *         Otherwise, <tt>null</tt> is returned
     * @throws FileNotFoundException if file does not exist or it is not a directory
     * @throws IllegalArgumentException if the name is <tt>null</tt> or blank, or if no element
     *         can be found by the name provided
     */
    public File getVerifiedDirectory(String name) throws FileNotFoundException, IllegalArgumentException {
        String element = getByName(name);
        File d = new File(name);
        if (!d.exists()) {
            throw new FileNotFoundException(String.format("File does not exist for name '%s': %s",
                                                          name, element));
        }
        if (!d.isDirectory()) {
            throw new FileNotFoundException("File is not a directory: " + d);
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
     * Initializes the configuration by parsing the configuration file and storing the data
     * elements.
     *
     * @param configFilePath the path to the configuration file to be parsed
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a
     *         file
     */
    private void initialize(String configFilePath) throws IOException, InvalidConfigurationException {
        try (ConfigFileParser parser = new ConfigFileParser(configFilePath)) {
            elements = parser.parseConfigFile();
        }
    }

    /**
     * Initializes the configuration by parsing the configuration file and storing the data
     * elements.
     *
     * @param is an input stream to the configuration file
     * @throws IOException if an I/O error should occur
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a
     *         file
     */
    private void initialize(InputStream is) throws IOException, InvalidConfigurationException {
        try (ConfigFileParser parser = new ConfigFileParser(is)) {
            elements = parser.parseConfigFile();
        }
    }

    /**
     * Gets an element by its provided name. This method also checks against invalid input
     * parameters, i.e., the method throws an {@link IllegalArgumentException} if <tt>name</tt>
     * is null or blank. If <tt>name</tt> fails to obtain a non-null value, an
     * {@link IllegalArgumentException} is also thrown.
     *
     * @param name the name used to find an element
     * @return the element
     * @throws IllegalArgumentException if <tt>name</tt> is <tt>null</tt> or blank, or if no
     *         element is found
     */
    private String getByName(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        String element = elements.get(name);
        if (element == null) {
            throw new IllegalArgumentException("No element exists for name: " + name);
        }
        return element;
    }

}
