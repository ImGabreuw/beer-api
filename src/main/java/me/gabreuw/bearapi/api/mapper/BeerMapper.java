package me.gabreuw.bearapi.api.mapper;

import me.gabreuw.bearapi.api.dto.BeerDTO;
import me.gabreuw.bearapi.domain.model.Beer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BeerMapper {

    BeerMapper INSTANCE = Mappers.getMapper(BeerMapper.class);

    BeerDTO toDTO(Beer beer);

    List<BeerDTO> toCollectionDTO(List<Beer> beers);

    Beer toEntity(BeerDTO beerDTO);
}
