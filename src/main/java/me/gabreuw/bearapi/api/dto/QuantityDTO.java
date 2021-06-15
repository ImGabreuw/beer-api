package me.gabreuw.bearapi.api.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
public class QuantityDTO implements Serializable {

    @NotNull
    @Max(100)
    private Integer quantity;

}
