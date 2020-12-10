public abstract class CardGame {

    public Creature[] creatures;

    public CardGame(Creature[] creatures) {
        this.creatures = creatures;
    }

    // returns -1 if no clear winner (both alive or both dead)
    public int combat(int creature1, int creature2) {
        Creature first = creatures[creature1];
        Creature second = creatures[creature2];
        hit(first, second);
        hit(second, first);
        boolean firstDead = first.health <= 0;
        boolean secondDead = second.health <= 0;
        if (firstDead && secondDead) {
            return -1;
        }
        if (firstDead) {
            return creature2;
        }
        if (secondDead) {
            return creature1;
        }
        return -1;
    }

    // attacker hits other creature
    protected abstract void hit(Creature attacker, Creature other);
}
