package fr.esprit.projectmanagerportal.repositories;

import fr.esprit.projectmanagerportal.entities.TaskGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {
}
