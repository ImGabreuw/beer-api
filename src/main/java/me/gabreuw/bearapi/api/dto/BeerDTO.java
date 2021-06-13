package me.gabreuw.bearapi.api.dto;

import lombok.Getter;
import me.gabreuw.bearapi.domain.model.enums.BeerType;

import java.io.Serializable;

@Getter
public class BeerDTO implements Serializable {

    private Long id;

    private String name;

    private String brand;

    private int max;

    private int quantity;

    private BeerType type;

}
