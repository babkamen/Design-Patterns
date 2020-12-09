import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionProcessorTest {

    @Test
    void calculate() {
        ExpressionProcessor expressionProcessor = new ExpressionProcessor();

//        assertEquals(6, expressionProcessor.calculate("1+2+3"));
        assertEquals(0, expressionProcessor.calculate("1+2+xy"));
        expressionProcessor.variables.put('x', 3);
        assertEquals(-4, expressionProcessor.calculate("1-2-x"));
    }
}