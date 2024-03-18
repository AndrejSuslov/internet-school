package by.andron.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorityDto {

    @NotNull
    private Long id;

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 6, max = 32, message = "Name cannot be lower than 6 characters and bigger than 32 characters")
    private String name;

}
