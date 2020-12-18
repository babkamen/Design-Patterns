package com.babkamen.visitor.acyclic

import spock.lang.Specification

class ExpressionPrinterTest extends Specification {
    def "Print operations without values for addition expression"() {
        given:
        def expression = new AdditionExpression(new ValueExpression(2), new ValueExpression(3))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(+)"
    }
    
    def "Print operations without values for mixup"() {
        given:
        def expression = new MultiplicationExpression(
                new AdditionExpression(new ValueExpression(2), new ValueExpression(3)),
                new ValueExpression(4))
        def printer = new ExpressionPrinter()
        when:
        printer.visit(expression)
        then:
        printer.toString() == "(+)*"
    }
}
