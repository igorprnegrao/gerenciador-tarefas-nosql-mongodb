package negraoipr.com.gerenciadortarefas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Document // igual a entity = tabela no mongoDB
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String password;


}
