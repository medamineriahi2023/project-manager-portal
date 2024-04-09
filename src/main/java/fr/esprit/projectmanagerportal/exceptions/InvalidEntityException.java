package fr.esprit.projectmanagerportal.exceptions;

import fr.esprit.projectmanagerportal.exceptions.abstracts.AbstractEntityException;
import fr.esprit.projectmanagerportal.handlers.ErrorCodes;

import java.util.List;

public class InvalidEntityException extends AbstractEntityException {

    public InvalidEntityException(String message , ErrorCodes errorCodes , List<String> errors){
        super(message, errorCodes, errors);
    }

    public InvalidEntityException(String message , ErrorCodes errorCodes){
        super(message,errorCodes);
    }
}
