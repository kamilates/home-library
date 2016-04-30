package todo.web

import spock.lang.Specification

class HelloWorldTest extends Specification {

    def "should welcome world"() {
        setup:
        HelloWorld helloWorld = new HelloWorld()

        when:
        String welcomeMessage = helloWorld.index()

        then:
        welcomeMessage == "Hello world!"
    }

}