package com.zakrywilson.commons.configuration;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    /** The name. */
    private static final int NAME = 0;

    /** The delimiter. */
    private static final int DELIMITER = 1;

    /** The element. */
    private static final int ELEMENT = 2;

    /** The comment. */
    private static final int COMMENT = 3;

    /**
     * Tests the "happy path" for the initialization of a {@link Line} which is accessed via the
     * constructor.
     *
     * @throws Exception if the parsing fails
     */
    @Test
    public void constructor() throws Exception {
        Line lineParser;
        String[][] strings =  {{"my_int",    ":",    "0",               ""},
                               {"my_char",   ": ",   "c",               " ######### Big comment"},
                               {"my_short",  " : " , "236",             "#"},
                               {"my_long",   "=",    "100L",            ""},
                               {"my_double", " = ",  "999999.999",      " # Comment #"},
                               {"my_float",  " = ",  "0.12345",         " # Here is a comment"},
                               {"my_string", ":",    "hello world",     ""},
                               {"my_byte",   "       ", "164",          ""},
                               {"my_file",   "\t",   "path/to/my/file", ""}};
        for (String[] string : strings) {
            String line = string[NAME] + string[DELIMITER] + string[ELEMENT] + string[COMMENT];
            lineParser = new Line(line);
            if (!lineParser.containsData()) {
                Assert.fail("Line should have contained data for line: " + line);
            }
            if (lineParser.getName().compareTo(string[NAME]) != 0) {
                Assert.fail(String.format("Line should have contained name '%s' instead of '%s'",
                        string[NAME], lineParser.getName()));
            }
            if (lineParser.getElement().compareTo(string[ELEMENT]) != 0) {
                Assert.fail(String.format("Line should have contained element '%s' instead of '%s'",
                        string[ELEMENT], lineParser.getElement()));
            }
        }
    }

}