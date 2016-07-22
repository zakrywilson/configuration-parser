package com.zakrywilson.commons.configuration;

/**
 * Represents a single line in the configuration file.
 *
 * @author Zach Wilson
 */
final class Line {

    /**
     * Flags whether or not this line contains relevant data (i.e., not an empty line or a comment).
     */
    private boolean containsData;

    /**
     * Contains the name of the data point in the configuration or the value in the map.
     */
    private String name;

    /**
     * Contains the data element of the data point in the configuration or the key in the map.
     */
    private String element;

    /**
     * Constructs a new line with a name and an element.
     *
     * @param line the line to be set
     * @throws InvalidConfigurationException if the configuration file is of an invalid format
     */
    public Line(final String line) throws InvalidConfigurationException {
        initialize(line);
    }

    /**
     * Gets the name of the element of the line.
     *
     * @return the name of the element
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the element data of the line.
     *
     * @return the element data of the element
     */
    public String getElement() {
        return element;
    }

    /**
     * Returns true if the line contains real data. Real data constitues as a name-value pair
     * (e.g., not an empty line or comment).
     *
     * @return <tt>true</tt> if the line contains data
     */
    public boolean containsData() {
        return containsData;
    }

    /**
     * Initializes the line by parsing out the <i>name</i> and <i>value</i>.
     *
     * @param line the line to be parsed
     * @throws InvalidConfigurationException if the configuration file is of an invalid format
     */
    private void initialize(final String line) throws InvalidConfigurationException {
        if (line == null || line.trim().length() == 0) {
            return;
        }

        // Check if line is a comment: i.e., a line beginning with a '#' character
        if (line.matches("^\\s*[#].*")) {
            return;
        }

        // Split the line by ':' and '=' with optional white space on either side
        final String[] pair = line.trim().split("\\s+|\\s*[=]\\s*|\\s*[:]\\s*");
        if (pair.length != 2) {
            throw new InvalidConfigurationException("Line contains more than a 'name' and 'value': '" + line + "'");
        }

        // Line is valid and contains data: store it
        this.name = pair[0];
        this.element = pair[1];
        containsData = true;
    }

}
