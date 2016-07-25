package com.zakrywilson.commons.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages parsing a configuration file.
 *
 * @author Zach Wilson
 */
final class ConfigFileParser implements AutoCloseable {

    /**
     * The input stream for the configuration file.
     */
    private InputStream stream;

    /**
     * Creates a new configuration file parser.
     *
     * @param configFilePath the path to the configuration file to be parsed
     * @throws IllegalArgumentException if the configuration file is <tt>null</tt>
     * @throws FileNotFoundException if the configuration file does not exist or is not a file
     */
    public ConfigFileParser(final String configFilePath) throws IllegalArgumentException, FileNotFoundException {
        initialize(configFilePath);
    }
    
    /**
     * Creates a new configuration file parser.
     *
     * @param is a file input stream to the configuration file
     * @throws IllegalArgumentException if the input stream is <tt>null</tt>
     */
    public ConfigFileParser(final InputStream is) throws IllegalArgumentException {
        if (is == null) {
            throw new IllegalArgumentException("Input stream cannot be null.");
        }
        this.stream = is;
    }

    /**
     * Parses the configuration file and returns the {@link Map} containing all of the data points.
     *
     * @return the collection of data
     * @throws IOException if an I/O exception occurs
     * @throws InvalidConfigurationException if the configuration file does not exist or is not a file
     */
    public Map<String, String> parseConfigFile() throws IOException, InvalidConfigurationException {
        final Map<String, String> elements = new HashMap<>();
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"))) {
            String nextLine = reader.readLine();
            while (nextLine != null) {
                final Line line = new Line(nextLine);
                if (line.containsData()) {
                    elements.put(line.getName(), line.getElement());
                }
                nextLine = reader.readLine();
            }
        }
        return elements;
    }
    
    /**
     * Closes {@link InputStream}.
     * 
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        if (stream != null) {
            stream.close();
        }
    }

    /**
     * Initializes the parser by verifying that the configuration file exists and is a file.
     *
     * @param path the path to the configuration file to be set
     * @throws IllegalArgumentException if the configuration file is <tt>null</tt>
     * @throws FileNotFoundException if the configuration file does not exist or is not a file
     */
    private void initialize(final String path) throws IllegalArgumentException, FileNotFoundException {
        if (path == null || path.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid config file path: " + path);
        }
        final File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist: " + path);
        }
        if (!file.isFile()) {
            throw new FileNotFoundException("File is not a file. Cannot process file: " + file.getAbsolutePath());
        }
        this.stream = new FileInputStream(file);
    }

}
