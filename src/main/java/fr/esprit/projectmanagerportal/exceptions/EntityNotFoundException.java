package fr.esprit.projectmanagerportal.exceptions;


import fr.esprit.projectmanagerportal.exceptions.abstracts.AbstractEntityException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;
import java.util.List;

public class EntityNotFoundException extends AbstractEntityException {

    public EntityNotFoundException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message,errorCodes,errors);
    }

    public EntityNotFoundException(String message , ErrorCodes errorCodes){
        super(message,errorCodes);
    }
}
