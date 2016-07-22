package com.aisolutions.program_i.configurationparser;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

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

    public Set parseConfigFile() throws IOException {
        List<String> lines = FileUtils.readLines(file, StandardCharsets.US_ASCII);
        for (String line : lines) {
            // TODO implement
        }
        return null;
    }

}
