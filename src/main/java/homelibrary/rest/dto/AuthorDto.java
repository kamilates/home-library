package homelibrary.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Getter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {

    private Long id;

    private String firstName;

    private String surname;

    private LocalDate birthDate;

    private LocalDate deathDate;

}
