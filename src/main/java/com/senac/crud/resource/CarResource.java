package com.senac.crud.resource;

import com.senac.crud.dto.CarDto;
import com.senac.crud.model.CarModel;
import com.senac.crud.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.smartcardio.Card;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/cars")
@Tag(name = "car", description = "Documentação relacionada a resource(recurso) car")
public class CarResource {

    final CarService carService;

    public CarResource(CarService carService) {this.carService = carService;}

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Cria um carro",
            description = "Método responsável para criar um carro no sistema")
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = CarModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "304", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public CarDto create(@RequestBody CarDto entity) {
        log.info("CarResource::create");
        return carService.create(entity);
    }

    @GetMapping(value = "/{id}",
    produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Recupera um carro baseado em um identificador",
            description = "Método responsável para recuperar um carro no sistema baseado no identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CarModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public CarDto get(@PathVariable Integer id) {
        log.info("CarResource::get(id)");
        return carService.read(id);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Recupera uma lista de carros",
            description = "Método responsável para recuperar uma lista de carros")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CarModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public List<CarDto> get() {
        log.info("CarResource::get()");
        return carService.read();
    }

    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um carro",
            description = "Método responsável para atualizar todos os dados de um carro.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CarModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public CarDto update(@PathVariable Integer id, @RequestBody CarDto entity) {
        log.info("CarResource::update(id,entity)");
        return carService.update(id, entity);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Delete um carro com base no identificador.",
            description = "Método responsável para deletar um carro com base no identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "206", content = { @Content(schema = @Schema(implementation = CarModel.class), mediaType = MediaType.APPLICATION_JSON_VALUE) }),
            @ApiResponse(responseCode = "303", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    public void delete(@PathVariable Integer id) {
        log.info("CarResource::delete(id)");
        carService.delete(id);
    }
    
}
