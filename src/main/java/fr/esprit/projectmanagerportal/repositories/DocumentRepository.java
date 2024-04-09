package fr.esprit.projectmanagerportal.repositories;

import fr.esprit.projectmanagerportal.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
