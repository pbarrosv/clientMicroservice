package bootcamp.everis.clientMicroservice.document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Customer")
public class Customer {

    @Id
    private Long id;
    @NotNull(message = "The DNI field must not be empty")
    private int dni;
    @NotEmpty(message = "The NAME field must not be empty")
    private String name;
    @NotEmpty(message = "The LASTNAME field must not be empty")
    private String lastname;
    @NotEmpty(message = "The DNI ADDRESS must not be empty")
    private String address;
    @NotEmpty(message = "The PHONE field must not be empty")
    private String phone;

}
