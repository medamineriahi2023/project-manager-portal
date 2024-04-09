package fr.esprit.projectmanagerportal.mappers;

import fr.esprit.projectmanagerportal.dtos.DocumentDTO;
import fr.esprit.projectmanagerportal.entities.Document;

public class DocumentMapper {

    public static DocumentDTO toDto(Document document){
        return DocumentDTO.builder().id(document.getId())
                .url(document.getUrl())
                .build();
    }


    public static Document toEntity(DocumentDTO documentDTO){
        Document document = Document.builder()
                .url(documentDTO.getUrl())
                .build();
        document.setId(documentDTO.getId());
        return document;
    }
}
