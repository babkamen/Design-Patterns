package intrusive_visitor

import spock.lang.Specification

class ExpressionVisitorTest extends Specification {
    def "Simple addition"() {
        given:
        def expression = new AdditionExpression(new Value(2), new Value(3))
        def sb = new StringBuilder()
        when:
        expression.print(sb)
        then:
        sb.toString() == "(2+3)"
    }
    
    def "Addition and multiplication mixup"() {
        given:
        def expression = new MultiplicationExpression(
                new AdditionExpression(new Value(2), new Value(3)),
                new Value(4))
        def sb = new StringBuilder()
        when:
        expression.print(sb)
        then:
        sb.toString() == "(2+3)*4"
    }
}
