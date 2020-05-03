package ru.stepanov.route.exceptions;

public class MsNotAllowedException extends MicroServiceException {

    public MsNotAllowedException() {
        super("Not allowed");
    }

    @Override
    public String staticMessage(){
        return "not_allowed_error";
    }
}