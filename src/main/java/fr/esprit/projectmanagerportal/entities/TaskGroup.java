package fr.esprit.projectmanagerportal.entities;

import fr.esprit.projectmanagerportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "task_groups_table")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskGroup extends AbstractEntity {

    private String name;
    private LocalDate demoDate;
    private LocalDate startDate;
    private  LocalDate estimatedEndDate;
    private LocalDate deliveredDate;
    @OneToMany
    private List<Task> tasks;
    @ManyToOne
    private Project project;
}
