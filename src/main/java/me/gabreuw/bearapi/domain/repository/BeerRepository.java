package me.gabreuw.bearapi.domain.repository;

import me.gabreuw.bearapi.domain.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeerRepository extends JpaRepository<Beer, Long> {

    Optional<Beer> findByName(String name);

}
