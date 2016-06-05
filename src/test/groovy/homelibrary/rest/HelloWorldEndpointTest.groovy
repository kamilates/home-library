package homelibrary.rest

import spock.lang.Specification

class HelloWorldEndpointTest extends Specification {

    def "should welcome world via endpoint"() {
        setup:
        HelloWorldEndpoint endpoint = new HelloWorldEndpoint()

        when:
        String welcomeMessage = endpoint.welcome()

        then:
        welcomeMessage == "Hello world endpoint!"
    }

}