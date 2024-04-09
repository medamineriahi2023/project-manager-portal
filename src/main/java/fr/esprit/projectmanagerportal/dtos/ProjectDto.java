package fr.esprit.projectmanagerportal.dtos;

import fr.esprit.projectmanagerportal.entities.Status;
import fr.esprit.projectmanagerportal.external.UserHrInfo;
import lombok.*;

import java.util.List;

@Data
@Builder
@ToString
public class ProjectDto {
    private Long id;
    private String title;
    private String description;
    private List<UserHrInfo> developers;
    private List<TaskGroupDto> groupsOfTasks;
    private List<DocumentDTO> Documents;
    private Status status;
    private String color;

}
