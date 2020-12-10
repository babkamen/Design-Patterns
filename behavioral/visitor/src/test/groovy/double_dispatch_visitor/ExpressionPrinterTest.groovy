package double_dispatch_visitor

import spock.lang.Specification

class ExpressionPrinterTest extends Specification {
    def "Simple addition"() {
        given:
        def expression = new AdditionExpression(new Value(2), new Value(3))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(2+3)"
    }

    def "Addition and multiplication mixup"() {
        given:
        def expression = new MultiplicationExpression(
                new AdditionExpression(new Value(2), new Value(3)),
                new Value(4))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(2+3)*4"
    }
}
