package com.project.DevHotel.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String observacoes;
    private int adultos;
    private int criancas;

}
