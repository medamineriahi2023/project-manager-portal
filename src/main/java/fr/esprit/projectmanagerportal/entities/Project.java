package fr.esprit.projectmanagerportal.entities;

import fr.esprit.projectmanagerportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "projects_table")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project extends AbstractEntity {
    private String title;
    private String description;
    private String developersIds;
    @OneToMany
    private List<TaskGroup> groupsOfTasks;
    @OneToMany
    private List<Document> documents;
    private Status status;
    private String color;

}
