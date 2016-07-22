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

    void setElement(final String name, final String element) {
        elements.put(name, element);
    }

    public int size() {
        return elements.size();
    }

    private void initialize(final String configFilePath) throws IOException, InvalidConfigurationException {
        final ConfigFileParser parser = new ConfigFileParser(configFilePath);
        elements = parser.parseConfigFile();
    }

}
