package negraoipr.com.gerenciadortarefas.services;

import lombok.RequiredArgsConstructor;
import negraoipr.com.gerenciadortarefas.repositories.UserRespository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;
}
