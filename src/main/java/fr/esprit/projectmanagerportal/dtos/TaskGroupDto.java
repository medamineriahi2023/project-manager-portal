package fr.esprit.projectmanagerportal.dtos;

import fr.esprit.projectmanagerportal.entities.Project;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class TaskGroupDto {
    private Long id;
    private String name;
    private LocalDate demoDate;
    private LocalDate startDate;
    private  LocalDate estimatedEndDate;
    private LocalDate deliveredDate;
    private List<TaskDto> tasks;
    private ProjectDto project;
}
