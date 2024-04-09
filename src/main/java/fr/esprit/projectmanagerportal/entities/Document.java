package fr.esprit.projectmanagerportal.entities;

import fr.esprit.projectmanagerportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "documents_table")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Document extends AbstractEntity {
    private String url;
}
