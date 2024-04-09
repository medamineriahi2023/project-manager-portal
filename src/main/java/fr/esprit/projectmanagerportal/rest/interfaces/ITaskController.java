package fr.esprit.projectmanagerportal.rest.interfaces;

import fr.esprit.projectmanagerportal.dtos.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITaskController {

    ResponseEntity<List<TaskDto>> getAllTasks();

    ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto);

    ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto);

    ResponseEntity<Void> deleteTask(@PathVariable Long taskId);
}
