package com.aisolutions.program_i.configurationparser;

public class Line {

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

        String[] pair = line.trim().split("\\s+|\\s*[=]\\s*|\\s*[:]\\s*");
        if (pair.length != 2) {
            throw new InvalidConfigurationException("Line contains more than a 'name' and 'value': '" + line + "'");
        }

        this.name = pair[0];
        this.element = pair[1];
        containsData = true;
    }

}
