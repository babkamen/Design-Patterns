public class TemporaryCardDamageGame extends CardGame {

    public TemporaryCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if (attacker.health > 0 && attacker.attack >= other.health) {
            other.health = 0;
        }
    }
}
