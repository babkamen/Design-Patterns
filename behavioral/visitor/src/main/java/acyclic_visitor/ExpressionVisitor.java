package acyclic_visitor;

interface Visitor {

}

interface AdditionExpressionVisitor extends Visitor {

    void visit(AdditionExpression expression);
}

interface ValueExpressionVisitor extends Visitor {

    void visit(Value expression);
}

interface MultiplicationExpressionVisitor extends Visitor {

    void visit(MultiplicationExpression expression);
}

abstract class Expression {

    abstract void accept(Visitor ev);
}

class Value extends Expression {

    public int value;

    public Value(int value) {
        this.value = value;
    }

    @Override
    void accept(Visitor v) {
        if (v instanceof ValueExpressionVisitor) {
            ((ValueExpressionVisitor) v).visit(this);
        }
    }
}

abstract class OperatorExpression extends Expression {

    public Expression lhs, rhs;

    public OperatorExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

class AdditionExpression extends OperatorExpression {

    public AdditionExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    void accept(Visitor v) {
        if (v instanceof AdditionExpressionVisitor) {
            ((AdditionExpressionVisitor) v).visit(this);
        }
    }
}

class MultiplicationExpression extends OperatorExpression {

    public MultiplicationExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    void accept(Visitor v) {
        if (v instanceof MultiplicationExpressionVisitor) {
            ((MultiplicationExpressionVisitor) v).visit(this);
        }
    }
}

class ExpressionPrinter implements AdditionExpressionVisitor,
        MultiplicationExpressionVisitor{

    private StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        return sb.toString();
    }


    @Override
    public void visit(AdditionExpression expression) {
        sb.append("(");
        expression.lhs.accept(this);
        sb.append("+");
        expression.rhs.accept(this);
        sb.append(")");
    }

    @Override
    public void visit(MultiplicationExpression expression) {
        expression.lhs.accept(this);
        sb.append("*");
        expression.rhs.accept(this);
    }
}