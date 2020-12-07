import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Token {
    public enum Type {
        Integer,
        VARIABLE,
        PLUS,
        MINUS
    }

    public Type type;
    public String text;

    public Token(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", text='" + text + '\'' +
                '}';
    }
}

interface Element {
    int eval();
}

class Integer implements Element {
    private int value;

    public Integer(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

    @Override
    public String toString() {
        return "Integer{" +
                "value=" + value +
                '}';
    }
}

class BinaryOperation implements Element {
    public enum Type {
        ADDITION,
        SUBTRACTION
    }

    public Element left, right;
    public Type type;

    @Override
    public int eval() {
        switch (type) {
            case ADDITION:
                return left.eval() + right.eval();
            case SUBTRACTION:
                return left.eval() - right.eval();
        }
        throw new RuntimeException("Cannot evaluate binary operation " + toString());
    }

    @Override
    public String toString() {
        return "BinaryOperation{" +
                " type=" + type +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}

class ExpressionProcessor {
    public Map<Character, java.lang.Integer> variables = new HashMap<>();

    private BinaryOperation parse(List<Token> tokens) {
        BinaryOperation result = new BinaryOperation();
        boolean haveLHS = false;
        for (Token token : tokens) {
            switch (token.type) {
                case VARIABLE:
                    if (!variables.containsKey(token.text.charAt(0))) {
                        throw new RuntimeException(String.format("Cannot find variable %s in map", token.text));
                    }
                    Integer integer = new Integer(variables.get(token.text.charAt(0)));
                    if (!haveLHS) {
                        result.left = integer;
                        haveLHS = true;
                    } else result.right = integer;
                    break;
                case Integer:
                    integer = new Integer(java.lang.Integer.parseInt(token.text));
                    if (!haveLHS) {
                        result.left = integer;
                        haveLHS = true;
                    } else result.right = integer;
                    break;
                case MINUS:
                    result.type = BinaryOperation.Type.SUBTRACTION;
                    break;
                case PLUS:
                    result.type = BinaryOperation.Type.ADDITION;
                    break;
                default:
                    break;
            }
            if (result.right != null) {
                result.left = new Integer(result.eval());
                result.right = null;
                result.type = null;
            }
        }
        return result;
    }

    public int calculate(String expression) {
        List<Token> tokens;
        try {
            tokens = lex(expression);
            System.out.println(tokens);

            BinaryOperation operation = parse(tokens);
            System.out.println(operation);
            return operation.left.eval();
        } catch (Exception e) {
            return 0;
        }
    }

    private List<Token> lex(String expression) throws VariableNameIsMoreThanOneSymbolException {
        ArrayList<Token> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            switch (c) {
                case '+':
                    result.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    result.add(new Token(Token.Type.MINUS, "-"));
                    break;
                default:
                    if (Character.isDigit(c)) {
                        StringBuilder sb = new StringBuilder("" + c);
                        for (int j = i + 1; j < expression.length(); j++) {
                            c = expression.charAt(j);
                            if (Character.isDigit(c)) {
                                sb.append(c);
                                i++;
                            } else {
                                break;
                            }
                        }
                        result.add(new Token(Token.Type.Integer, sb.toString()));
                    }
                    if (Character.isAlphabetic(c)) {
                        if (i + 1 < expression.length() && Character.isAlphabetic(expression.charAt(i + 1))) {
                            throw new VariableNameIsMoreThanOneSymbolException();
                        }
                        result.add(new Token(Token.Type.VARIABLE, String.valueOf(c)));
                    }
                    break;
            }
        }
        return result;
    }
}

class VariableNameIsMoreThanOneSymbolException extends Exception {

}