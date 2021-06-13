package me.gabreuw.bearapi.domain.model;

import lombok.Data;
import me.gabreuw.bearapi.domain.model.enums.BeerType;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private int max;

    @Column(nullable = false)
    private int quantity;

    @Enumerated(STRING)
    @Column(nullable = false)
    private BeerType type;

}
