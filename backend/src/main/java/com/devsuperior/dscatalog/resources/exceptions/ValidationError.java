package com.devsuperior.dscatalog.resources.exceptions;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends StandardError{

    private List<FiledMessage> errors = new ArrayList<>();

    public void addError(String fieldName, String message){
        errors.add(new FiledMessage(fieldName, message));
    }
}
