package me.gabreuw.bearapi.domain.service.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(BAD_REQUEST)
public class BeerStockExceededException extends RuntimeException {

    public BeerStockExceededException(Long id, int quantityToIncrement) {
        super(String.format(
                "Beers with %s ID to increment informed exceeds the max stock capacity: %s",
                id, quantityToIncrement
        ));
    }

}
