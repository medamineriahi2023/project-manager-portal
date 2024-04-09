package fr.esprit.projectmanagerportal.services.interfaces;

import fr.esprit.projectmanagerportal.dtos.TaskDto;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import fr.esprit.projectmanagerportal.entities.Task;

import java.util.List;

public interface ITaskService {
    List<TaskDto> getAllTasks();

    TaskDto update(TaskDto taskDto);

    void delete(Long id);

    TaskDto create(TaskDto taskDto);
}
