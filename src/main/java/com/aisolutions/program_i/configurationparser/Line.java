package com.aisolutions.program_i.configurationparser;

final class Line {

    private boolean containsData;

    private String name;

    private String element;

    public Line(final String line) throws InvalidConfigurationException {
        initialize(line);
    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public boolean containsData() {
        return containsData;
    }

    private void initialize(final String line) throws InvalidConfigurationException {
        if (line == null || line.trim().length() == 0) {
            return;
        }

        // Check if line is a comment: i.e., a line beginning with a '#' character.
        if (line.matches("^\\s*[#].*")) {
            return;
        }

        // Split the line by ':' and '=' with optional white space on either side.
        final String[] pair = line.trim().split("\\s+|\\s*[=]\\s*|\\s*[:]\\s*");
        if (pair.length != 2) {
            throw new InvalidConfigurationException("Line contains more than a 'name' and 'value': '" + line + "'");
        }

        // Line is valid and contains data: store it.
        this.name = pair[0];
        this.element = pair[1];
        containsData = true;
    }

}
