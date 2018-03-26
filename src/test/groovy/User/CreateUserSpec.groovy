package User

import spock.lang.Specification

class CreateUserSpec extends Specification {

    def 'base test' () {
        given:
            def i = 3
        when:
            i = i + 1
        then:
            i == 4
    }
}
