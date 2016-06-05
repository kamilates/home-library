package bookregister.service

import spock.lang.Specification


class EnumValueListingServiceImplTest extends Specification {

    private EnumValueListingService enumValueListingService

    def setup() {
        enumValueListingService = new EnumValueListingServiceImpl()
    }

    def "returns values for a defined enum"() {
        when:
        List<String> enumValues = enumValueListingService.getValuesForEnum("Gender")

        then:
        enumValues.size() == 2
        enumValues.get(0) == "FEMALE"
        enumValues.get(1) == "MALE"
    }

    def "returns null for a undefined enum"() {
        when:
        List<String> enumValues = enumValueListingService.getValuesForEnum("NoSuchEnum")

        then:
        enumValues == null
    }

}