package exercise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeBuilderTest {

    @Test
    public void test() {
        String expectedCode = "public class Person" +
                "\n{\n" +
                "  public String name;\n" +
                "  public int age;\n" +
                "}";
        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name", "String").addField("age", "int");
        assertEquals(expectedCode, codeBuilder.toString());
    }
}