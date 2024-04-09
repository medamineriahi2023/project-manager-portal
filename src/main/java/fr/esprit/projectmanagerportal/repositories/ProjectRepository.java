package fr.esprit.projectmanagerportal.repositories;

import fr.esprit.projectmanagerportal.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
