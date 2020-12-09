package exercise;

public class CodeBuilder {

    private final int indentionLevel = 2;
    private StringBuilder sb = new StringBuilder();

    public CodeBuilder(String className) {
        sb.append(String.format("public class %s\n{\n", className));
    }

    public CodeBuilder addField(String name, String type) {
        sb.append(" ".repeat(indentionLevel));
        sb.append(String.format("public %s %s;\n", type, name));
        return this;
    }

    @Override
    public String toString() {
        return sb.toString() + "}";
    }
}