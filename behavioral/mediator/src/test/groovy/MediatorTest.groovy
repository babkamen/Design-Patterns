import spock.lang.Specification

import java.util.stream.Collectors

class MediatorTest extends Specification {
    def "happy path test"() {
        given:
        Mediator mediator = new Mediator();
        Participant participant1 = new Participant(1, mediator);
        Participant participant2 = new Participant(2, mediator);
        Participant participant3 = new Participant(3, mediator);
        List<Participant> participants = List.of(participant1, participant2, participant3);
        when:
        participant1.say(2);
        participant3.say(3);
        def values = participants.stream().map(Participant::getValue).collect(Collectors.toList())
        then:
        values == [3, 5, 2]
    }
}
