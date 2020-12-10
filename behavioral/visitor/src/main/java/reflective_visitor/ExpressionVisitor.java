package reflective_visitor;

interface ExpressionVisitor {

    void print(Expression e);
}

abstract class Expression {

}

class Value extends Expression {

    public int value;

    public Value(int value) {
        this.value = value;
    }

}

class AdditionExpression extends Expression {

    public Expression lhs, rhs;

    public AdditionExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }
}

class MultiplicationExpression extends Expression {

    public Expression lhs, rhs;

    public MultiplicationExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

}

class ExpressionPrinter implements ExpressionVisitor {

    private StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        return sb.toString();
    }

    public void print(Expression e) {
        if (e instanceof AdditionExpression) {
            AdditionExpression expr = (AdditionExpression) e;
            sb.append("(");
            print(expr.lhs);
            sb.append("+");
            print(expr.rhs);
            sb.append(")");
        } else if (e instanceof MultiplicationExpression) {
            MultiplicationExpression expr = (MultiplicationExpression) e;
            print(expr.lhs);
            sb.append("*");
            print(expr.rhs);
        } else if (e instanceof Value) {
            sb.append(((Value) e).value);
        }
    }
}