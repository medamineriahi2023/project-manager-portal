package fr.esprit.projectmanagerportal.rest.interfaces;

import fr.esprit.projectmanagerportal.dtos.DocumentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

public interface IDocumentController {

    ResponseEntity<List<DocumentDTO>> getAllDocuments();

    ResponseEntity<DocumentDTO> createDocument(@RequestBody DocumentDTO documentDto) throws IOException;


    ResponseEntity<Void> deleteDocument(@PathVariable Long documentId);
}
