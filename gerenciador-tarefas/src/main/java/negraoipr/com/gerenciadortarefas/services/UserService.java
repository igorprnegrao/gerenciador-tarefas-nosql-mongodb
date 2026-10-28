package negraoipr.com.gerenciadortarefas.services;

import lombok.RequiredArgsConstructor;
import negraoipr.com.gerenciadortarefas.models.User;
import negraoipr.com.gerenciadortarefas.repositories.UserRespository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRespository userRespository;


    public List<User> findAll() {
        return userRespository.findAll();
    }

    public User findById(String id) {
        return userRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        return userRespository.save(user);
    }

    public User update(User user) {
        var userEntity = userRespository.findById(user.getId());
        BeanUtils.copyProperties(user, userEntity, "id");
        return userRespository.save(user);
    }

    public void delete(String id) {
        userRespository.deleteById(id);
    }
}
