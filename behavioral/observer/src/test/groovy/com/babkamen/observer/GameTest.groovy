package com.babkamen.observer


import spock.lang.Specification

class GameTest extends Specification {

    def "Rats test"() {
        given:
        def game = new Game()
        when:
        def rat = new Rat(game)
        def rats = [] as List<Rat>
        for (i in 0..<100) {
            rats.add(new Rat(game))
        }
        for (i in 0..<30) {
            rats[i].close()
        }
        then:
        rat.getAttack() == 71
    }
}
