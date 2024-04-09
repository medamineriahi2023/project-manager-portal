package fr.esprit.projectmanagerportal.services.interfaces;

import fr.esprit.projectmanagerportal.dtos.DocumentDTO;

import java.io.IOException;
import java.util.List;

public interface IDocumentService {
    List<DocumentDTO> getAllProjects();


    void delete(Long id);

    DocumentDTO create(DocumentDTO documentDTO) throws IOException;
}
