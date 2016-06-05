package homelibrary

import homelibrary.rest.EnumEndpoint
import homelibrary.service.EnumValueListingService
import jersey.repackaged.com.google.common.collect.Lists
import spock.lang.Specification

import javax.ws.rs.core.Response


class EnumEndpointTest extends Specification {

    private EnumValueListingService enumValueListingServiceMock

    private EnumEndpoint enumEndpoint

    def setup() {
        enumValueListingServiceMock = Mock()
        enumValueListingServiceMock.getValuesForEnum("ExistingEnum") >> Lists.newArrayList("FEMALE", "MALE")
        enumValueListingServiceMock.getValuesForEnum("NotExistingEnum") >> null
        enumEndpoint = new EnumEndpoint(enumValueListingServiceMock)
    }

    def "returns list and 200 code when enum is found"() {
        when:
        Response response = enumEndpoint.getAllValues("ExistingEnum")

        then:
        response.status == 200
    }

    def "returns 404 for when enum is not found"() {
        when:
        Response response = enumEndpoint.getAllValues("NotExistingEnum")

        then:
        response.status == 404
    }

}