package homelibrary.rest.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Getter
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {

    private Long id;

    private String name;

    private Set<BookDto> books;
}
