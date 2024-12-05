package com.senac.crud.resource;

import com.senac.crud.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/carros")
public class CarResource {

    final CarService carService;

    public CarResource(CarService carService) {this.carService = carService;}

    
}
