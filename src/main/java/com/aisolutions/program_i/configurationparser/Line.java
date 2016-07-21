package com.aisolutions.program_i.configurationparser;

public class Line {

    private LineType type;

    private String name;

    private String data;

    public Line() {}

    public LineType getLineType() {
        return type;
    }

    public Line setLineType(final LineType type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public Line setName(final String name) {
        this.name = name;
        return this;
    }

    public String getData() {
        return data;
    }

    public Line setData(final String data) {
        this.data = data;
        return this;
    }

}
