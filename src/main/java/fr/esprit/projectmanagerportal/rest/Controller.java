package fr.esprit.projectmanagerportal.rest;

import fr.esprit.projectmanagerportal.dtos.DocumentDTO;
import fr.esprit.projectmanagerportal.dtos.ProjectDto;
import fr.esprit.projectmanagerportal.dtos.TaskDto;
import fr.esprit.projectmanagerportal.dtos.TaskGroupDto;
import fr.esprit.projectmanagerportal.rest.interfaces.IDocumentController;
import fr.esprit.projectmanagerportal.rest.interfaces.IProjectController;
import fr.esprit.projectmanagerportal.rest.interfaces.ITaskController;
import fr.esprit.projectmanagerportal.rest.interfaces.ITaskGroupController;
import fr.esprit.projectmanagerportal.services.interfaces.IDocumentService;
import fr.esprit.projectmanagerportal.services.interfaces.IGroupOfTaskservice;
import fr.esprit.projectmanagerportal.services.interfaces.IProjectService;
import fr.esprit.projectmanagerportal.services.interfaces.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project-service")
public class Controller implements IProjectController, ITaskController, ITaskGroupController, IDocumentController {

    private final IProjectService projectService;
    private final ITaskService taskService;
    private final IGroupOfTaskservice taskGroupService;
    private final IDocumentService documentService;



    @Override
    @GetMapping("/projects")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok().body(projects);
    }

    @Override
    @PostMapping("/projects")
    public ResponseEntity<ProjectDto> createProject(@RequestBody @Valid ProjectDto projectDto) {
        ProjectDto createdProject = projectService.create(projectDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdProject.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdProject);
    }

    @Override
    @PutMapping("/projects")
    public ResponseEntity<ProjectDto> updateProject(@RequestBody @Valid ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.update(projectDto);
        return ResponseEntity.ok().body(updatedProject);
    }

    @Override
    @DeleteMapping("/projects/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long projectId) {
        projectService.delete(projectId);
        return ResponseEntity.noContent().build();
    }

    // Task methods
    @Override
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok().body(tasks);
    }

    @Override
    @PostMapping("/tasks")
    public ResponseEntity<TaskDto> createTask(@RequestBody @Valid TaskDto taskDto) {
        TaskDto createdTask = taskService.create(taskDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTask);
    }

    @Override
    @PutMapping("/tasks")
    public ResponseEntity<TaskDto> updateTask(@RequestBody @Valid TaskDto taskDto) {
        TaskDto updatedTask = taskService.update(taskDto);
        return ResponseEntity.ok().body(updatedTask);
    }

    @Override
    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.delete(taskId);
        return ResponseEntity.noContent().build();
    }

    // TaskGroup methods
    @Override
    @GetMapping("/task-groups")
    public ResponseEntity<List<TaskGroupDto>> getAllTaskGroups() {
        List<TaskGroupDto> taskGroups = taskGroupService.getAllProjects();
        return ResponseEntity.ok().body(taskGroups);
    }

    @Override
    @PostMapping("/task-groups")
    public ResponseEntity<TaskGroupDto> createTaskGroup(@RequestBody @Valid TaskGroupDto taskGroupDto) {
        TaskGroupDto createdTaskGroup = taskGroupService.create(taskGroupDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTaskGroup.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdTaskGroup);
    }

    @Override
    @PutMapping("/task-groups")
    public ResponseEntity<TaskGroupDto> updateTaskGroup(@RequestBody @Valid TaskGroupDto taskGroupDto) {
        TaskGroupDto updatedTaskGroup = taskGroupService.update(taskGroupDto);
        return ResponseEntity.ok().body(updatedTaskGroup);
    }

    @Override
    @DeleteMapping("/task-groups/{taskGroupId}")
    public ResponseEntity<Void> deleteTaskGroup(@PathVariable Long taskGroupId) {
        taskGroupService.delete(taskGroupId);
        return ResponseEntity.noContent().build();
    }

    // Document methods
    @Override
    @GetMapping("/documents")
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
        List<DocumentDTO> documents = documentService.getAllProjects();
        return ResponseEntity.ok().body(documents);
    }

    @Override
    @PostMapping("/documents")
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody @Valid DocumentDTO documentDto) throws IOException {
        DocumentDTO createdDocument = documentService.create(documentDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdDocument.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdDocument);
    }

    @Override
    @DeleteMapping("/documents/{documentId}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long documentId) {
        documentService.delete(documentId);
        return ResponseEntity.noContent().build();
    }
}

