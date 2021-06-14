package me.gabreuw.bearapi.api.dto;

import lombok.Getter;
import me.gabreuw.bearapi.domain.model.enums.BeerType;

import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.EnumType.STRING;

@Getter
public class BeerDTO implements Serializable {

    private Long id;

    @NotNull
    @Size(min = 1, max = 200)
    private String name;

    @NotNull
    @Size(min = 1, max = 200)
    private String brand;

    @NotNull
    @Max(500)
    private int max;

    @NotNull
    @Max(100)
    private int quantity;

    @NotNull
    @Enumerated(STRING)
    private BeerType type;

}
