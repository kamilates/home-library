@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type = LocalDate.class,
                value = LocalDateAdapter.class)
})
package homelibrary.rest.dto;

import homelibrary.converter.LocalDateAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;