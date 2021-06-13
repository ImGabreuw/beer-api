package me.gabreuw.bearapi.domain.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(Long id) {
        super("Beer not found by ID " + id);
    }

    public BeerNotFoundException(String name) {
        super("Beer not found by name " + name);
    }

}
