package fr.esprit.projectmanagerportal.dtos;

import fr.esprit.projectmanagerportal.entities.Status;
import fr.esprit.projectmanagerportal.entities.TaskTag;
import fr.esprit.projectmanagerportal.entities.TaskUrgency;
import fr.esprit.projectmanagerportal.external.UserHrInfo;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class TaskDto {
        private Long id;
        private String name;
        private UserHrInfo employee;
        private LocalDateTime deadLine;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String description;
        private String toDoList;
        private ProjectDto project;
        private TaskGroupDto taskGroupDto;
        private Status taskStatus;
        private TaskTag taskTag;
        private TaskUrgency taskUrgency;
}
