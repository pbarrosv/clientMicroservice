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
    @NotNull(message = "El campo dni no debe estar vacio")
    private int dni;
    @NotEmpty(message = "El campo name no debe estar vacio")
    private String name;
    @NotEmpty(message = "El campo lastname no debe estar vacio")
    private String lastname;
    @NotEmpty(message = "El campo address no debe estar vacio")
    private String address;
    @NotEmpty(message = "El campo phone no debe estar vacio")
    private String phone;

}
