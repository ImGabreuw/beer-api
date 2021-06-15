package me.gabreuw.bearapi.api.resource;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import me.gabreuw.bearapi.api.dto.BeerDTO;
import me.gabreuw.bearapi.api.dto.QuantityDTO;
import me.gabreuw.bearapi.domain.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping(path = "/api/v1/beers")
public class BeerResource {

    private final BeerService SERVICE;

    @PostMapping
    @ResponseStatus(CREATED)
    public BeerDTO createBeer(@RequestBody @Valid BeerDTO beerDTO) {
        return SERVICE.createBear(beerDTO);
    }

    @GetMapping(path = "/{name}")
    public BeerDTO findByName(@PathVariable String name) {
        return SERVICE.findByName(name);
    }

    @GetMapping
    public List<BeerDTO> findAll() {
        return SERVICE.findAll();
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        SERVICE.deleteById(id);
    }

    @PatchMapping(path = "/{id}/increment")
    public BeerDTO increment(
            @PathVariable Long id,
            @RequestBody @Valid QuantityDTO quantityDTO
    ) {
        return SERVICE.increment(id, quantityDTO.getQuantity());
    }
}
