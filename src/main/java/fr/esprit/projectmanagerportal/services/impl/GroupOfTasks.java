package fr.esprit.projectmanagerportal.services.impl;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import fr.esprit.projectmanagerportal.entities.TaskGroup;
import fr.esprit.projectmanagerportal.exceptions.EntityNotFoundException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;
import fr.esprit.projectmanagerportal.mappers.GroupOfTaskMapper;
import fr.esprit.projectmanagerportal.mappers.ProjectMapper;
import fr.esprit.projectmanagerportal.mappers.TaskMapper;
import fr.esprit.projectmanagerportal.repositories.TaskGroupRepository;
import fr.esprit.projectmanagerportal.services.interfaces.IGroupOfTaskservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GroupOfTasks implements IGroupOfTaskservice {
    private final TaskGroupRepository taskGroupRepository;
    private final SelfServiceClient selfServiceClient;
    @Override
    public List<TaskGroupDto> getAllProjects() {
        List<TaskGroup> taskGroups = taskGroupRepository.findAll();
       return taskGroups.stream()
                .map(taskGroup -> GroupOfTaskMapper.toDto(taskGroup, selfServiceClient))
                .toList();
    }


    @Override
    public TaskGroupDto update(TaskGroupDto taskGroupDto) {
        TaskGroup taskGroup = taskGroupRepository.findById(taskGroupDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Id with this task group is not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(taskGroupDto.getName())) {
            taskGroup.setName(taskGroupDto.getName());
        }

        if (Objects.nonNull(taskGroupDto.getDemoDate())) {
            taskGroup.setDemoDate(taskGroupDto.getDemoDate());
        }

        if (Objects.nonNull(taskGroupDto.getStartDate())) {
            taskGroup.setStartDate(taskGroupDto.getStartDate());
        }

        if (Objects.nonNull(taskGroupDto.getEstimatedEndDate())) {
            taskGroup.setEstimatedEndDate(taskGroupDto.getEstimatedEndDate());
        }

        if (Objects.nonNull(taskGroupDto.getDeliveredDate())) {
            taskGroup.setDeliveredDate(taskGroupDto.getDeliveredDate());
        }

        if (Objects.nonNull(taskGroupDto.getProject())) {
            taskGroup.setProject(ProjectMapper.toEntity(taskGroupDto.getProject()));
        }

        if (Objects.nonNull(taskGroupDto.getTasks())) {
            taskGroup.setTasks(taskGroupDto.getTasks().stream()
                    .map(TaskMapper::toEntity)
                    .toList());
        }

        return GroupOfTaskMapper.toDto(taskGroup, selfServiceClient);
    }


    @Override
    public void delete(Long id) {
        taskGroupRepository.deleteById(id);
    }

    @Override
    public TaskGroupDto create(TaskGroupDto taskGroupDto) {
        TaskGroup taskGroup = GroupOfTaskMapper.toEntity(taskGroupDto);
        TaskGroup savedTaskGroup = taskGroupRepository.save(taskGroup);
        return GroupOfTaskMapper.toDto(savedTaskGroup, selfServiceClient);
    }

}
