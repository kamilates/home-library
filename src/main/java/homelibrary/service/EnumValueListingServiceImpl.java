package homelibrary.service;

import homelibrary.model.enums.Gender;
import homelibrary.model.enums.Nationality;
import jersey.repackaged.com.google.common.collect.Lists;
import jersey.repackaged.com.google.common.collect.Maps;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnumValueListingServiceImpl implements EnumValueListingService {

    private static final HashMap<String, Class> visibleEnums = Maps.newHashMap();

    static {
        visibleEnums.put("Gender", Gender.class);
        visibleEnums.put("Nationality", Nationality.class);
    }

    public List<String> getValuesForEnum(String enumName) {
        Class enumClass = visibleEnums.get(enumName);

        if (enumClass == null) {
            return null;
        }

        return Lists.newArrayList(enumClass.getFields())
                .stream()
                .map(Field::getName)
                .collect(Collectors.toList());
    }

}
