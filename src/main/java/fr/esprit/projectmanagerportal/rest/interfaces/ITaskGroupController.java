package fr.esprit.projectmanagerportal.rest.interfaces;

import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ITaskGroupController {

    ResponseEntity<List<TaskGroupDto>> getAllTaskGroups();

    ResponseEntity<TaskGroupDto> createTaskGroup(@RequestBody TaskGroupDto taskGroupDto);

    ResponseEntity<TaskGroupDto> updateTaskGroup(@RequestBody TaskGroupDto taskGroupDto);

    ResponseEntity<Void> deleteTaskGroup(@PathVariable Long taskGroupId);
}
