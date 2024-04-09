package fr.esprit.projectmanagerportal.services.impl;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.TaskDto;
import fr.esprit.projectmanagerportal.entities.Task;
import fr.esprit.projectmanagerportal.exceptions.EntityNotFoundException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;
import fr.esprit.projectmanagerportal.mappers.GroupOfTaskMapper;
import fr.esprit.projectmanagerportal.mappers.ProjectMapper;
import fr.esprit.projectmanagerportal.mappers.TaskMapper;
import fr.esprit.projectmanagerportal.repositories.TaskRepository;
import fr.esprit.projectmanagerportal.services.interfaces.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {
    private final TaskRepository taskRepository;
    private final SelfServiceClient selfServiceClient;

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> TaskMapper.toDto(task, selfServiceClient))
                .toList();
    }

    @Override
    public TaskDto update(TaskDto taskDto) {
        Task task = taskRepository.findById(taskDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Task with id " + taskDto.getId() + " not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(taskDto.getName())) {
            task.setName(taskDto.getName());
        }

        if (Objects.nonNull(taskDto.getEmployee())) {
            task.setEmployeeId(taskDto.getEmployee().getUserDto().getUserId());
        }

        if (Objects.nonNull(taskDto.getDeadLine())) {
            task.setDeadLine(taskDto.getDeadLine());
        }

        if (Objects.nonNull(taskDto.getStartDate())) {
            task.setStartDate(taskDto.getStartDate());
        }

        if (Objects.nonNull(taskDto.getEndDate())) {
            task.setEndDate(taskDto.getEndDate());
        }

        if (Objects.nonNull(taskDto.getDescription())) {
            task.setDescription(taskDto.getDescription());
        }

        if (Objects.nonNull(taskDto.getToDoList())) {
            task.setToDoList(taskDto.getToDoList());
        }

        if (Objects.nonNull(taskDto.getProject())) {
            task.setProject(ProjectMapper.toEntity(taskDto.getProject()));
        }

        if (Objects.nonNull(taskDto.getTaskGroupDto())) {
            task.setTaskGroup(GroupOfTaskMapper.toEntity(taskDto.getTaskGroupDto()));
        }

        if (Objects.nonNull(taskDto.getTaskStatus())) {
            task.setTaskStatus(taskDto.getTaskStatus());
        }

        if (Objects.nonNull(taskDto.getTaskTag())) {
            task.setTaskTag(taskDto.getTaskTag());
        }

        if (Objects.nonNull(taskDto.getTaskUrgency())) {
            task.setTaskUrgency(taskDto.getTaskUrgency());
        }

        return TaskMapper.toDto(task, selfServiceClient);
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto create(TaskDto taskDto) {
        Task task = TaskMapper.toEntity(taskDto);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toDto(savedTask, selfServiceClient);
    }
}
