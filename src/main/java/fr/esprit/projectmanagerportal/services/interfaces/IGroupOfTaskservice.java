package fr.esprit.projectmanagerportal.services.interfaces;

import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;

import java.util.List;

public interface IGroupOfTaskservice {
    List<TaskGroupDto> getAllProjects();

    TaskGroupDto update(TaskGroupDto taskGroupDto);

    void delete(Long id);

    TaskGroupDto create(TaskGroupDto taskGroupDto);
}
