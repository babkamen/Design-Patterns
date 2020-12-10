import spock.lang.Specification

class TemporaryCardDamageGameTest extends Specification {
    def "In temporary damage game creature cannot kill another creature if it's attack less then opponent health "() {
        def creature1 = new Creature(1, 2)
        def creature2 = new Creature(1, 2)
        def game = new TemporaryCardDamageGame(creature1, creature2)
        when:
        def winner = game.combat(0, 1)
        for (i in 0..<100)
            winner = game.combat(0, 1)
        then:
        winner == -1
        creature1.health == 2
        creature2.health == 2
    }
}
