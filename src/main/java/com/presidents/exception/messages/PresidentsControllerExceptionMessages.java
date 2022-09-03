package com.presidents.exception.messages;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PresidentsControllerExceptionMessages {

    ENTITY_FOR_PROVIDED_ID_NOT_EXISTED("Encja dla podanego id nie istnieje"),
    ENTITY_FOR_PROVIDED_NAME_NOT_EXISTED ("Encja dla podanego imienia nie istnieje");

    private final String message;

//    PresidentsControllerExceptionMessages(String message) {
//        this.message = message;
//    }
}
