package me.gabreuw.bearapi.domain.service;

import lombok.RequiredArgsConstructor;
import me.gabreuw.bearapi.api.dto.BeerDTO;
import me.gabreuw.bearapi.api.mapper.BeerMapper;
import me.gabreuw.bearapi.domain.model.Beer;
import me.gabreuw.bearapi.domain.repository.BeerRepository;
import me.gabreuw.bearapi.domain.service.exception.BeerAlreadyRegisteredException;
import me.gabreuw.bearapi.domain.service.exception.BeerNotFoundException;
import me.gabreuw.bearapi.domain.service.exception.BeerStockExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class BeerService {

    private final BeerRepository REPOSITORY;
    private final BeerMapper MAPPER = BeerMapper.INSTANCE;

    public BeerDTO createBear(BeerDTO beerDTO) {
        verifyIfIsAlreadyRegistered(beerDTO.getName());

        var savedBeer = REPOSITORY.save(
                MAPPER.toEntity(beerDTO)
        );

        return MAPPER.toDTO(savedBeer);
    }

    public BeerDTO findByName(String name) {
        var recoveredBeer = REPOSITORY.
                findByName(name)
                .orElseThrow(() -> new BeerNotFoundException(name));

        return MAPPER.toDTO(recoveredBeer);
    }

    public List<BeerDTO> findAll() {
        return MAPPER.toCollectionDTO(
                REPOSITORY.findAll()
        );
    }

    public void deleteById(Long id) {
        verifyIfExists(id);
        REPOSITORY.deleteById(id);
    }

    private void verifyIfIsAlreadyRegistered(String name) {
        if (REPOSITORY.findByName(name).isPresent()) {
            throw new BeerAlreadyRegisteredException(name);
        }
    }

    private Beer verifyIfExists(Long id) {
        return REPOSITORY.findById(id)
                .orElseThrow(() -> new BeerNotFoundException(id));
    }

    public BeerDTO increment(Long id, int quantityToIncrement) {
        var beerToIncrementStock = verifyIfExists(id);
        var quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantity();

        if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
            beerToIncrementStock.setQuantity(beerToIncrementStock.getQuantity() + quantityToIncrement);
            Beer incrementedBeerStock = REPOSITORY.save(beerToIncrementStock);

            return MAPPER.toDTO(incrementedBeerStock);
        }
        throw new BeerStockExceededException(id, quantityToIncrement);
    }
}
