package fr.esprit.projectmanagerportal.mappers;

import fr.esprit.projectmanagerportal.clients.SelfServiceClient;
import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.entities.Project;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProjectMapper {


    public static ProjectDto toDto(Project project, SelfServiceClient selfServiceClient){
        return ProjectDto.builder().id(project.getId())
                .description(project.getDescription())
                .title(project.getTitle())
                .developers(selfServiceClient.getUsersInfoByUsersIdsBulk(Arrays.asList(project.getDevelopersIds().split("\\s*,\\s*"))))
                .color(project.getColor())
                .Documents(project.getDocuments().stream().map(DocumentMapper::toDto).toList())
                .status(project.getStatus())
                .groupsOfTasks(project.getGroupsOfTasks().stream().map(g-> GroupOfTaskMapper.toDto(g,selfServiceClient)).toList())
                .build();
    }


    public static Project toEntity(ProjectDto projectDto){
        Project project = Project.builder()
                .description(projectDto.getDescription())
                .title(projectDto.getTitle())
                .developersIds(projectDto.getDevelopers().stream().map(e -> e.getUserDto().getUserId()).collect(Collectors.joining(",")))
                .color(projectDto.getColor())
                .documents(projectDto.getDocuments().stream().map(DocumentMapper::toEntity).toList())
                .status(projectDto.getStatus())
                .groupsOfTasks(projectDto.getGroupsOfTasks().stream().map(GroupOfTaskMapper::toEntity).toList())
                .build();
        project.setId(projectDto.getId());
        return project;
    }

}
