package com.babkamen.visitor.reflective

import spock.lang.Specification

class ExpressionPrinterTest extends Specification {
    def "Simple addition"() {
        given:
        def expression = new AdditionExpression(new ValueExpression(2), new ValueExpression(3))
        def printer = new ExpressionPrinter()
        when:
        printer.print(expression)
        then:
        printer.toString() == "(2+3)"
    }

    def "Addition and multiplication mixup"() {
        given:
        def expression = new MultiplicationExpression(
                new AdditionExpression(new ValueExpression(2), new ValueExpression(3)),
                new ValueExpression(4))
        def printer = new ExpressionPrinter()
        when:
        printer.print(expression)
        then:
        printer.toString() == "(2+3)*4"
    }
}
