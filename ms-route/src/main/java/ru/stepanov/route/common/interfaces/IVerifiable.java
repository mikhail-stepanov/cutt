package ru.stepanov.route.common.interfaces;

import org.springframework.validation.Errors;

public interface IVerifiable {

    void verify(Errors errors);
}
