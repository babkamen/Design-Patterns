package com.babkamen.visitor.double_dispatch;

abstract class ExpressionVisitor {

    abstract void visit(ValueExpression value);

    abstract void visit(AdditionExpression ae);

    abstract void visit(MultiplicationExpression me);
}

interface Expression {

    void accept(ExpressionVisitor ev);
}

class ValueExpression implements Expression {

    public int value;

    public ValueExpression(int value) {
        this.value = value;
    }

    @Override
    public void accept(ExpressionVisitor ev) {
        ev.visit(this);
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
    public void accept(ExpressionVisitor ev) {
        ev.visit(this);
    }
}

class MultiplicationExpression extends BinaryOperationExpression {


    protected MultiplicationExpression(Expression lhs, Expression rhs) {
        super(lhs, rhs);
    }

    @Override
    public void accept(ExpressionVisitor ev) {
        ev.visit(this);
    }
}

class ExpressionPrinter extends ExpressionVisitor {

    private StringBuilder sb = new StringBuilder();

    @Override
    public String toString() {
        return sb.toString();
    }

    @Override
    void visit(ValueExpression value) {
        sb.append(value.value);
    }

    @Override
    void visit(AdditionExpression ae) {
        sb.append("(");
        ae.lhs.accept(this);
        sb.append("+");
        ae.rhs.accept(this);
        sb.append(")");
    }

    @Override
    void visit(MultiplicationExpression me) {
        me.lhs.accept(this);
        sb.append("*");
        me.rhs.accept(this);
    }
}