package ru.stepanov.ms.client.common.interfaces;

import org.springframework.validation.Errors;

public interface IVerifiable {

    void verify(Errors errors);
}
