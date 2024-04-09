package fr.esprit.projectmanagerportal.services.interfaces;

import fr.esprit.projectmanagerportal.dtos.ProjectDto;

import java.util.List;

public interface IProjectService {
    List<ProjectDto> getAllProjects();

    ProjectDto update(ProjectDto projectDto);

    void delete(Long id);

    ProjectDto create(ProjectDto projectDto);
}
