import spock.lang.Specification

class AccountTest extends Specification {
    def "SomeOperation"() {
        when:
        def account = new Account(new NullLog())
        account.someOperation()
        account.someOperation()
        account.someOperation()
        account.someOperation()
        then:
        true
    }
}
