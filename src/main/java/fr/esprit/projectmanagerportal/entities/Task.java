package fr.esprit.projectmanagerportal.entities;

import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import fr.esprit.projectmanagerportal.dtos.UserDto;
import fr.esprit.projectmanagerportal.entities.abstracts.AbstractEntity;
import fr.esprit.projectmanagerportal.external.UserHrInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task extends AbstractEntity {
        private String name;
        private String employeeId;
        private LocalDateTime deadLine;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private String description;
        private String toDoList;
        @ManyToOne
        private Project project;
        @ManyToOne
        private TaskGroup taskGroup;
        private Status taskStatus;
        private TaskTag taskTag;
        private TaskUrgency taskUrgency;
}
