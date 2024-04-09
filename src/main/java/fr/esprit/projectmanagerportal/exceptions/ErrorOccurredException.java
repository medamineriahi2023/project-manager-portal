package fr.esprit.projectmanagerportal.exceptions;


import fr.esprit.projectmanagerportal.exceptions.abstracts.AbstractEntityException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;
import java.util.List;
public class ErrorOccurredException extends AbstractEntityException {

    public ErrorOccurredException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message,errorCodes,errors);
    }

    public ErrorOccurredException(String message , ErrorCodes errorCodes){
        super(message,errorCodes);
    }
}
