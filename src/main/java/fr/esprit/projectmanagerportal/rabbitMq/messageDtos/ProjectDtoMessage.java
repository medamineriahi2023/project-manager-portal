package fr.esprit.projectmanagerportal.rabbitMq.messageDtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDtoMessage {
    private Long id;
    private String title;
    private String description;

}
