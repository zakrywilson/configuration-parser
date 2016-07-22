package com.aisolutions.program_i.configurationparser;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class Config {

    private Map<String, String> elements;

    public Config(final String configFilePath) throws IOException, InvalidConfigurationException {
        initialize(configFilePath);
    }

    public Set<String> getNames() {
        return elements.keySet();
    }

    public Collection<String> getElements() {
        return elements.values();
    }

    public Set<Map.Entry<String, String>> getEntries() {
        return elements.entrySet();
    }

    public String getElement(final String name) {
        return elements.get(name);
    }

    public char getElementAsChar(final String name) throws TypeMismatchException {
        final String value = elements.get(name);
        if (value.length() != 1) {
            throw new TypeMismatchException("Value is not a single character: " + value);
        }
        return value.charAt(0);
    }

    public short getElementAsShort(final String name) throws TypeMismatchException {
        try {
            return Short.parseShort(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a short: " + elements.get(name), e);
        }
    }

    public byte getElementAsByte(final String name) throws TypeMismatchException {
        try {
            return Byte.parseByte(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a byte: " + elements.get(name), e);
        }
    }

    public int getElementAsInteger(final String name) throws TypeMismatchException {
        try {
            return Integer.parseInt(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not an integer: " + elements.get(name));
        }
    }

    public float getElementAsFloat(final String name) throws TypeMismatchException {
        try {
            return Float.parseFloat(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a float: " + elements.get(name));
        }
    }

    public double getElementAsDouble(final String name) throws TypeMismatchException {
        try {
            return Double.parseDouble(elements.get(name));
        } catch (NumberFormatException e) {
            throw new TypeMismatchException("Value is not a double: " + elements.get(name));
        }
    }

    public int size() {
        return elements.size();
    }

    private void initialize(final String configFilePath) throws IOException, InvalidConfigurationException {
        final ConfigFileParser parser = new ConfigFileParser(configFilePath);
        elements = parser.parseConfigFile();
    }

}
