package todo

import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.boot.test.WebIntegrationTest
import spock.lang.Specification
import todo.rest.HelloWorldEndpoint

import javax.inject.Inject

@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
class ApplicationTest extends Specification {

    @Inject
    HelloWorldEndpoint helloWorldEndpoint

    def "should start application"() {
        expect:
        helloWorldEndpoint != null
    }

}