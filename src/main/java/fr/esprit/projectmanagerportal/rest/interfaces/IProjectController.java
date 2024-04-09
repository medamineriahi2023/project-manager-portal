package fr.esprit.projectmanagerportal.rest.interfaces;


import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IProjectController {

    ResponseEntity<List<ProjectDto>> getAllProjects();

    ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto);

    ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto);

    ResponseEntity<Void> deleteProject(@PathVariable Long projectId);
}
