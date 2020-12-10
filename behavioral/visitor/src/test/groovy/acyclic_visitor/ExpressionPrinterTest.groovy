package acyclic_visitor

import spock.lang.Specification

class ExpressionPrinterTest extends Specification {
    def "Print operations without values for addition expression"() {
        given:
        def expression = new AdditionExpression(new Value(2), new Value(3))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(+)"
    }
    
    def "Print operations without values for mixup"() {
        given:
        def expression = new MultiplicationExpression(
                new AdditionExpression(new Value(2), new Value(3)),
                new Value(4))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(+)*"
    }
}
