package com.babkamen.visitor.intrusive;

interface Expression {

    void print(StringBuilder sb);
}

class ValueExpression implements Expression {

    public int value;

    public ValueExpression(int value) {
        this.value = value;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append(value);
    }
}

abstract class BinaryOperationExpression implements Expression {

    public Expression lhs, rhs;

    protected BinaryOperationExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
    }

}

class AdditionExpression extends BinaryOperationExpression {

    protected AdditionExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append("(");
        lhs.print(sb);
        sb.append("+");
        rhs.print(sb);
        sb.append(")");
    }
}


class MultiplicationExpression extends BinaryOperationExpression {

    protected MultiplicationExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public void print(StringBuilder sb) {
        lhs.print(sb);
        sb.append("*");
        rhs.print(sb);
    }
}

