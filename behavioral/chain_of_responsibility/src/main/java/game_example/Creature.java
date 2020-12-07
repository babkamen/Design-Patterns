package game_example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;


interface Creature {
    int getAttack();

    int getDefense();
}

class Game {
    public Event<Query> queries = new Event<>();
    public List<Creature> creatures = new ArrayList<>();
}

class Goblin implements Creature, AutoCloseable {
    protected int baseAtk = 1, baseDef = 1;
    private Game game;
    protected int token;

    public Goblin(Game game) {
        this.game = game;
        this.token = game.queries.subscribe(this::applyModifier);
        System.out.println("Adding goblin#" + token);
    }

    @Override
    public int getAttack() {
        Query query = new Query(this, Statistic.ATTACK, this.baseAtk);
        game.queries.fire(query);
        System.out.println("goblin#" + token + " atk=" + query.getResult());
        return query.getResult();
    }

    @Override
    public int getDefense() {
        Query query = new Query(this, Statistic.DEFENSE, this.baseDef);
        game.queries.fire(query);
        System.out.println("goblin#" + token + " def=" + query.getResult());
        return query.getResult();
    }

    //gets +1 defense for every other goblin including goblin king
    protected void applyModifier(Query query) {
        if (query.getCreature() != this && query.getStatistic() == Statistic.DEFENSE) {
            query.setResult(query.getResult() + 1);
        }
    }

    @Override
    public void close() {
        System.out.println("Kill goblin#" + token);
        this.game.queries.unsubscribe(token);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " #=" + token + "{" +
                " atk=" + this.getAttack() +
                ", def=" + this.getDefense() +
                '}';
    }
}

class GoblinKing extends Goblin {

    public GoblinKing(Game game) {
        super(game);
        baseAtk = 3;
        baseDef = 3;
        System.out.println("Added goblin king#"+token);
    }

    //when Goblin king in game every goblin gets +1 atk
    protected void applyModifier(Query query) {
        super.applyModifier(query);
        if (query.getCreature() != this && query.getStatistic() == Statistic.ATTACK) {
            System.out.println("Increase atk on goblin king#"+token);
            query.setResult(query.getResult() + 1);
        }
    }

}

enum Statistic {
    ATTACK, DEFENSE
}

class Event<TArgs> {
    private int index = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public int subscribe(Consumer<TArgs> consumer) {
        handlers.put(++index, consumer);
        return index;
    }

    public void unsubscribe(int token) {
        handlers.remove(token);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> consumer : handlers.values()) {
            consumer.accept(args);
        }
    }
}

class Query {

    private Creature creature;
    private Statistic statistic;
    private int result;

    public Query(Creature creature, Statistic statistic, int result) {
        this.creature = creature;
        this.statistic = statistic;
        this.result = result;
    }

    public Creature getCreature() {
        return creature;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}

class Demo {
    public static void main(String[] args) {
        Game game = new Game();
        Goblin goblin = new Goblin(game);
        Goblin goblin2 = new Goblin(game);
        Goblin goblin3 = new Goblin(game);
        GoblinKing goblinKing = new GoblinKing(game);
        System.out.println(goblin);
        System.out.println(goblinKing);
    }
}