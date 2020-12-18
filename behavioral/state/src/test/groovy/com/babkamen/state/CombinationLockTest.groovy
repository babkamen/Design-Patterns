package com.babkamen.state
import spock.lang.Specification

class CombinationLockTest extends Specification {
    def "As a user when I enter right combination I should get OPEN status"() {
        when:
        def lock = new CombinationLock(new int[]{1, 2, 3, 4})
        then:
        lock.status == States.LOCKED.getValue()
        when:
        lock.enterDigit(1);
        then:
        lock.status == "1"
        when:
        lock.enterDigit(2);
        then:
        lock.status == "12"
        when:
        lock.enterDigit(3);
        then:
        lock.status == "123"
        when:
        lock.enterDigit(4);
        then:
        lock.status == States.OPEN.getValue()
    }

    def "As a user I should get ERROR status when I enter wrong combination"() {
        when:
        def lock = new CombinationLock(new int[]{1, 2, 3, 4})
        then:
        lock.status == States.LOCKED.getValue()
        when:
        lock.enterDigit(1);
        then:
        lock.status == "1"
        when:
        lock.enterDigit(2);
        then:
        lock.status == "12"
        when:
        lock.enterDigit(3);
        then:
        lock.status == "123"
        when:
        lock.enterDigit(5);
        then:
        lock.status == States.ERROR.getValue()
    }
}