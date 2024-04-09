package fr.esprit.projectmanagerportal.services.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import fr.esprit.projectmanagerportal.dtos.DocumentDTO;
import fr.esprit.projectmanagerportal.entities.Document;
import fr.esprit.projectmanagerportal.mappers.DocumentMapper;
import fr.esprit.projectmanagerportal.repositories.DocumentRepository;
import fr.esprit.projectmanagerportal.services.interfaces.IDocumentService;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class DocumentService implements IDocumentService {

    public final DocumentRepository documentRepository;

   Map params1;
    Cloudinary cloudinary;
    public DocumentService(DocumentRepository documentRepository){
        this.documentRepository = documentRepository;
        Dotenv dotenv = Dotenv.load();
        cloudinary = new Cloudinary(dotenv.get("CLOUDINARY_URL"));
        cloudinary.config.secure = true;
        params1 = ObjectUtils.asMap(
                "use_filename", true,
                "unique_filename", false,
                "overwrite", true
        );
    }

    @Override
    public List<DocumentDTO> getAllProjects() {
       return documentRepository.findAll().stream().map(DocumentMapper::toDto).toList();
    }

    @Override
    public void delete(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public DocumentDTO create(DocumentDTO documentDTO) throws IOException {
        Document document = new Document(cloudinary.uploader().upload(documentDTO.getUrl(), params1).get("secure_url").toString());
        return DocumentMapper.toDto(documentRepository.save(document));

    }
}
