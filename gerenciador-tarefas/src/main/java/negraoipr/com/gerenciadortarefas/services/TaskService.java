package negraoipr.com.gerenciadortarefas.services;

import lombok.RequiredArgsConstructor;
import negraoipr.com.gerenciadortarefas.models.Task;
import negraoipr.com.gerenciadortarefas.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;


    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task save(Task task) {
        var user = userService.findById(task.getUser().getId());
        task.setUser(user);
        return taskRepository.save(task);
    }

    public void completed(Task task) {
        var users = findById(task.getUser().getId());
        task.setUser(users.getUser());
        task.setCompleted(true);
        taskRepository.save(task);
    }

    public void delete(String id) {
        var task = findById(id);
        taskRepository.delete(task);
    }
}
