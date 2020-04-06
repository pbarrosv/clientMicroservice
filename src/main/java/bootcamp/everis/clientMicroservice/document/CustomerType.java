package bootcamp.everis.clientMicroservice.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "CustomerType")
public class CustomerType {

    @Id
    private Long idCT;
    @NotNull(message = "The TYPEC field must not be empty")
    private String typeC;

}
