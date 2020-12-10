package intrusive_visitor;

abstract class Expression
{
    public abstract void print(StringBuilder sb);;
}

class Value extends Expression
{
    public int value;

    public Value(int value)
    {
        this.value = value;
    }

    @Override
    public void print(StringBuilder sb) {
        sb.append(value);
    }
}

class AdditionExpression extends Expression {

    public Expression lhs, rhs;

    public AdditionExpression(Expression lhs, Expression rhs) {
        this.lhs = lhs;
        this.rhs = rhs;
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


class MultiplicationExpression extends Expression
{
    public Expression lhs, rhs;

    public MultiplicationExpression(Expression lhs, Expression rhs)
    {
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void print(StringBuilder sb) {
        lhs.print(sb);
        sb.append("*");
        rhs.print(sb);
    }
}

