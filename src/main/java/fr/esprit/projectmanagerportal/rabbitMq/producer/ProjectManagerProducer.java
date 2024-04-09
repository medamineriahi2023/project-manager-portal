package fr.esprit.projectmanagerportal.rabbitMq.producer;

import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.rabbitMq.messageDtos.ProjectDtoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class ProjectManagerProducer {
    private final RabbitTemplate rabbitTemplate;

    public void sendMessage(ProjectDto projectDto){
        ProjectDtoMessage projectDtoMessage =
                ProjectDtoMessage.builder()
                        .id(projectDto.getId())
                        .title(projectDto.getTitle())
                        .description(projectDto.getDescription())
                        .build();
        rabbitTemplate.convertAndSend("selfServiceRatingQueue", projectDtoMessage);

    }
}
