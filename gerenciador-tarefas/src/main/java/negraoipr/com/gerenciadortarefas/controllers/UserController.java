package negraoipr.com.gerenciadortarefas.controllers;


import lombok.RequiredArgsConstructor;
import negraoipr.com.gerenciadortarefas.models.User;
import negraoipr.com.gerenciadortarefas.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        var  users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        var userId = userService.findById(id);
        return ResponseEntity.ok(userId);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        var userId = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userId);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        var userId = userService.update(user);
        return ResponseEntity.ok(userId);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
