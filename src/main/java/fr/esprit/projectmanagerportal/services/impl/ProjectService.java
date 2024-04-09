package fr.esprit.projectmanagerportal.services.impl;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.entities.Project;
import fr.esprit.projectmanagerportal.exceptions.EntityNotFoundException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;
import fr.esprit.projectmanagerportal.mappers.DocumentMapper;
import fr.esprit.projectmanagerportal.mappers.GroupOfTaskMapper;
import fr.esprit.projectmanagerportal.mappers.ProjectMapper;
import fr.esprit.projectmanagerportal.repositories.ProjectRepository;
import fr.esprit.projectmanagerportal.services.interfaces.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService implements IProjectService {
    private final SelfServiceClient selfServiceClient;
    private final ProjectRepository projectRepository;
    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(project -> ProjectMapper.toDto(project, selfServiceClient))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto update(ProjectDto projectDto) {
        Project project = projectRepository.findById(projectDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Project with id " + projectDto.getId() + " not found", ErrorCodes.ENTITY_NOT_FOUND));

        if (Objects.nonNull(projectDto.getTitle())) {
            project.setTitle(projectDto.getTitle());
        }

        if (Objects.nonNull(projectDto.getDescription())) {
            project.setDescription(projectDto.getDescription());
        }

        if (Objects.nonNull(projectDto.getColor())) {
            project.setColor(projectDto.getColor());
        }

        if (Objects.nonNull(projectDto.getDevelopers())) {
            project.setDevelopersIds(projectDto.getDevelopers().stream().map(userHrInfo -> userHrInfo.getUserDto().getUserId()).collect(Collectors.joining(",")));
        }

        if (Objects.nonNull(projectDto.getDocuments())) {
            project.setDocuments(projectDto.getDocuments().stream().map(DocumentMapper::toEntity).toList());
        }

        if (Objects.nonNull(projectDto.getStatus())) {
            project.setStatus(projectDto.getStatus());
        }

        if (Objects.nonNull(projectDto.getGroupsOfTasks())) {
            project.setGroupsOfTasks(projectDto.getGroupsOfTasks().stream().map(GroupOfTaskMapper::toEntity).toList());
        }

        return ProjectMapper.toDto(project, selfServiceClient);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectDto create(ProjectDto projectDto) {
        Project project = ProjectMapper.toEntity(projectDto);
        Project savedProject = projectRepository.save(project);
        return ProjectMapper.toDto(savedProject, selfServiceClient);
    }
}
