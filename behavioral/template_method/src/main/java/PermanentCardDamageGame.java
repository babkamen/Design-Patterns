public class PermanentCardDamageGame extends CardGame {

    public PermanentCardDamageGame(Creature[] creatures) {
        super(creatures);
    }

    @Override
    protected void hit(Creature attacker, Creature other) {
        if (attacker.health > 0 && other.health > 0) {
            if (attacker.attack > other.health) other.health = 0;
            else
                other.health -= attacker.attack;
        }
    }
}