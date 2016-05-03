package bookregister.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonAutoDetect
public class AuthorDto {

    private Long id;

    private String firstName;

    private String surname;

}
