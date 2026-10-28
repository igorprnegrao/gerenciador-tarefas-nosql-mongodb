package negraoipr.com.gerenciadortarefas.controllers;


import lombok.RequiredArgsConstructor;
import negraoipr.com.gerenciadortarefas.models.Task;
import negraoipr.com.gerenciadortarefas.models.User;
import negraoipr.com.gerenciadortarefas.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;


    @GetMapping
    public ResponseEntity<List<Task>> findAll() {
        var  tasks = taskService.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("{id}")
    public ResponseEntity<Task> findById(@RequestParam("id") String id) {
        var taskId = taskService.findById(id);
        return ResponseEntity.ok(taskId);
    }

    @PostMapping
    public ResponseEntity<Task> save(@RequestBody Task task) {
        var taskId = taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskId);
    }

    @GetMapping("/{id}/completed")
    public ResponseEntity<Void> completed(@PathVariable("id") Task task) {
        taskService.completed(task);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
