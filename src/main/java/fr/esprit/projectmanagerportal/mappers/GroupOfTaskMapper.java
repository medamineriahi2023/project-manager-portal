package fr.esprit.projectmanagerportal.mappers;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import fr.esprit.projectmanagerportal.entities.TaskGroup;

public class GroupOfTaskMapper {

    public static TaskGroupDto toDto(TaskGroup taskGroup, SelfServiceClient selfServiceClient){
        return TaskGroupDto.builder()
                .id(taskGroup.getId())
                .name(taskGroup.getName())
                .deliveredDate(taskGroup.getDeliveredDate())
                .estimatedEndDate(taskGroup.getEstimatedEndDate())
                .startDate(taskGroup.getStartDate())
                .demoDate(taskGroup.getDemoDate())
                .project(ProjectMapper.toDto(taskGroup.getProject(), selfServiceClient))
                .tasks(taskGroup.getTasks().stream().map(t -> TaskMapper.toDto(t,selfServiceClient)).toList())
                .build();
    }


    public static TaskGroup toEntity(TaskGroupDto taskGroupDto){
        TaskGroup taskGroup = TaskGroup.builder()
                .name(taskGroupDto.getName())
                .deliveredDate(taskGroupDto.getDeliveredDate())
                .estimatedEndDate(taskGroupDto.getEstimatedEndDate())
                .startDate(taskGroupDto.getStartDate())
                .demoDate(taskGroupDto.getDemoDate())
                .project(ProjectMapper.toEntity(taskGroupDto.getProject()))
                .tasks(taskGroupDto.getTasks().stream().map(TaskMapper::toEntity).toList())
                .build();
        taskGroup.setId(taskGroupDto.getId());
        return taskGroup;
    }
}
