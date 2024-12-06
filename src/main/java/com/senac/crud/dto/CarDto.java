package com.senac.crud.dto;


import lombok.Data;

@Data
public class CarDto {

    private Integer id;

    private String placa;

    private String marca;

    private String modelo;

    private String cor;

    private Integer ano;
}
