package fr.esprit.projectmanagerportal.mappers;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.TaskDto;
import fr.esprit.projectmanagerportal.entities.Task;

public class TaskMapper {

    public static TaskDto toDto(Task task, SelfServiceClient selfServiceClient){
        return TaskDto.builder()
                .id(task.getId())
                .employee(selfServiceClient.getUserInfoByUserId(task.getEmployeeId()))
                .name(task.getName())
                .deadLine(task.getDeadLine())
                .startDate(task.getStartDate())
                .endDate(task.getEndDate())
                .description(task.getDescription())
                .toDoList(task.getToDoList())
                .project(ProjectMapper.toDto(task.getProject(),selfServiceClient))
                .taskGroupDto(GroupOfTaskMapper.toDto(task.getTaskGroup(), selfServiceClient))
                .taskStatus(task.getTaskStatus())
                .taskTag(task.getTaskTag())
                .taskUrgency(task.getTaskUrgency())
                .build();
    }


    public static Task toEntity(TaskDto taskDto){
        Task task = Task.builder()
                .name(taskDto.getName())
                .employeeId(taskDto.getEmployee().getUserDto().getUserId())
                .name(taskDto.getName())
                .deadLine(taskDto.getDeadLine())
                .startDate(taskDto.getStartDate())
                .endDate(taskDto.getEndDate())
                .description(taskDto.getDescription())
                .toDoList(taskDto.getToDoList())
                .project(ProjectMapper.toEntity(taskDto.getProject()))
                .taskGroup(GroupOfTaskMapper.toEntity(taskDto.getTaskGroupDto()))
                .taskStatus(taskDto.getTaskStatus())
                .taskTag(taskDto.getTaskTag())
                .taskUrgency(taskDto.getTaskUrgency())
                .build();
        task.setId(taskDto.getId());
        return task;
    }
}
