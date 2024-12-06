package com.senac.crud.service;

import com.senac.crud.dto.CarDto;
import com.senac.crud.mapper.CarMapper;
import com.senac.crud.model.CarModel;
import com.senac.crud.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CarService {
    final CarRepository carRepository;
    final CarMapper carMapper;

    public CarService(CarRepository carRepository, CarMapper carMapper) {this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public CarDto create(CarDto dto) {
        log.info("CarService::create");

        CarModel carModel = carMapper.toModel(dto); // aqui vc converte

         CarModel carModelGravado = carRepository.save(carModel); // aqui grava no banco

        CarDto carDto = carMapper.toDto(carModelGravado); // aqui vc converte para a camada adjacente

         return carDto; // retorna o objeto preenchido
    }

    public CarDto read(Integer id) {
        log.info("CarService::read(id)");

        CarModel carPesquisado = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        CarDto carDto = carMapper.toDto(carPesquisado); // aqui vc converte para a camada adjacente

        return carDto; // retorna o objeto preenchido
    }

    public List<CarDto> read() {
        log.info("CarService::read()");

        List<CarModel> carModelList = carRepository.findAll();

        return carMapper.toDtoList(carModelList);

    }

    public CarDto update(Integer id, CarDto entity) {
        log.info("CarService::update(id,entity");

        CarModel carPesquisado = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Id pesquisado não existe:{}"));

        carPesquisado.setAno(entity.getAno());
        carPesquisado.setCor(entity.getCor());
        carPesquisado.setPlaca(entity.getPlaca());
        carPesquisado.setMarca(entity.getMarca());
        carPesquisado.setModelo(entity.getModelo());

        CarModel carAtualizado = carRepository.save(carPesquisado);

        CarDto carDto = carMapper.toDto(carAtualizado);

        return carDto;
    }

    public void delete(Integer id) {
        log.info("CarService::delete(id)");

        carRepository.deleteById(id);

    }


}
