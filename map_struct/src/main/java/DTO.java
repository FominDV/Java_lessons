import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTO {

    LocalDateTime date;

    String name;

    Cat cat;

    String car;
    int carNumber;
}
