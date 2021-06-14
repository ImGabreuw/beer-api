package me.gabreuw.bearapi.domain.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(NOT_FOUND)
public class BeerNotFoundException extends RuntimeException {

    public BeerNotFoundException(String beerName) {
        super(String.format(
                "Beer with name %s not found in the system.",
                beerName
        ));
    }

    public BeerNotFoundException(Long beerId) {
        super(String.format(
                "Beer with id %s not found in the system.",
                beerId
        ));
    }

}
