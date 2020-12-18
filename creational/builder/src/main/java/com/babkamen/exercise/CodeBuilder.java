package com.babkamen.exercise;

public class CodeBuilder {

    private static final int INDENTION_LEVEL = 2;
    private StringBuilder sb = new StringBuilder();

    public CodeBuilder(String className) {
        sb.append(String.format("public class %s%n{%n", className));
    }

    public CodeBuilder addField(String name, String type) {
        sb.append(" ".repeat(INDENTION_LEVEL));
        sb.append(String.format("public %s %s;%n", type, name));
        return this;
    }

    @Override
    public String toString() {
        return sb.toString() + "}";
    }
}