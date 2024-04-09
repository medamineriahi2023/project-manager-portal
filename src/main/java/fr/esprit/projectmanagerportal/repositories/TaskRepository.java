package fr.esprit.projectmanagerportal.repositories;

import fr.esprit.projectmanagerportal.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
