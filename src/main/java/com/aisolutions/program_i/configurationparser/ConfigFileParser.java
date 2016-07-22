package com.aisolutions.program_i.configurationparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class ConfigFileParser {

    private File file;

    public ConfigFileParser(final String configFilePath) throws IllegalArgumentException, FileNotFoundException {
        initialize(configFilePath);
    }

    private void initialize(final String path) throws FileNotFoundException {
        if (path == null || path.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid config file path: " + path);
        }
        file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File does not exist: " + path);
        }
        if (!file.isFile()) {
            throw new FileNotFoundException("File is not a file. Cannot process file: " +
                                            file.getAbsolutePath());
        }
    }

    public Map<String, String> parseConfigFile() throws IOException, InvalidConfigurationException {
        Map<String, String> elements = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8)) {
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

}
