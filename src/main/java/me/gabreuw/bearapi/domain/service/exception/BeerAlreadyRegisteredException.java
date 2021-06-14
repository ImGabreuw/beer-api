package me.gabreuw.bearapi.domain.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class BeerAlreadyRegisteredException extends RuntimeException {

    public BeerAlreadyRegisteredException(String beerName) {
        super(String.format(
                "Beer with name %s already registered in the system.",
                beerName
        ));
    }

}
