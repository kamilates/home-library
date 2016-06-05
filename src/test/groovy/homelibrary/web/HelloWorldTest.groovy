package homelibrary.web

import spock.lang.Specification

class HelloWorldTest extends Specification {

    def "should welcome world"() {
        setup:
        HelloWorld helloWorld = new HelloWorld(null, null)

        when:
        String welcomeMessage = helloWorld.index()

        then:
        welcomeMessage == "index.html"
    }

}