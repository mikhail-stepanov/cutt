package ru.stepanov.ms.client.exceptions;

public class MsNotAllowedException extends MicroServiceException {

    public MsNotAllowedException() {
        super("низя");
    }

    @Override
    public String staticMessage(){
        return "not_allowed_error";
    }
}