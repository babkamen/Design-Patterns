import spock.lang.Specification

class PermanentCardDamageGameTest extends Specification {
    def "Happy path case"() {
        def creature1 = new Creature(5, 10)
        def creature2 = new Creature(1, 15)
        def game = new PermanentCardDamageGame(creature1, creature2)
        when:
        def winner = game.combat(0, 1)
        for (i in 0..<3)
            winner = game.combat(0, 1)
        then:
        winner == 0
        creature2.health == 0

    }
}
