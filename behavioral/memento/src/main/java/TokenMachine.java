import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class TokenMachine {

    @Getter
    private List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value) {
        System.out.println("Adding token with value " + value);
        tokens.add(new Token(value));
        return new Memento(tokens);
    }

    public Memento addToken(Token token) {
        System.out.println("Adding token reference with value " + token.getValue());
        tokens.add(token);
        return new Memento(tokens);
    }

    public void revert(Memento m) {
        System.out.println("Reverting to memento " + m);
        this.tokens = m.getTokens();
    }
}
