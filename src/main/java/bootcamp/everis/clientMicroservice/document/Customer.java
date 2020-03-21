package bootcamp.everis.clientMicroservice.document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Customer")
public class Customer {

    @Id
    private Long id;
    private int dni;
    private String name;
    private String lastname;
    private String address;
    private String phone;

}
