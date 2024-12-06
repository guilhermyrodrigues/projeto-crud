package com.senac.crud.mapper;

import com.senac.crud.dto.CarDto;
import com.senac.crud.model.CarModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    //Converte entidade para DTO
    CarDto toDto(CarModel entity);

    //Converte DTO para entidade
    CarModel toModel(CarDto dto);

    //Converter a lista de entidades para lista de DTos
    List<CarDto> toDtoList(List<CarModel> entity);

    //Converter lista de DTOs para lista de entidades
    List<CarModel> toModelList(List<CarDto> dto);
}
