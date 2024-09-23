package com.project.DevHotel.service;

import com.project.DevHotel.data.ReservaEntity;
import com.project.DevHotel.data.ReservaRepository;
import com.project.DevHotel.model.Reserva;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

// Método para converter Reserva para ReservaEntity
    private ReservaEntity toEntity(Reserva reserva) {
        ReservaEntity entity = new ReservaEntity();
        entity.setNome(reserva.getNome());
        entity.setEmail(reserva.getEmail());

        // Converter String para LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        entity.setDataEntrada(LocalDate.parse(reserva.getDataEntrada(), formatter));
        entity.setDataSaida(LocalDate.parse(reserva.getDataSaida(), formatter));

        entity.setObservacoes(reserva.getObservacoes());
        entity.setAdultos(reserva.getAdultos());
        entity.setCriancas(reserva.getCriancas());
        return entity;
    }

// Método para converter ReservaEntity para Reserva
    private Reserva toModel(ReservaEntity entity) {
        Reserva reserva = new Reserva();
        reserva.setNome(entity.getNome());
        reserva.setEmail(entity.getEmail());

        // Converter LocalDate para String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        reserva.setDataEntrada(entity.getDataEntrada().format(formatter));
        reserva.setDataSaida(entity.getDataSaida().format(formatter));

        reserva.setObservacoes(entity.getObservacoes());
        reserva.setAdultos(entity.getAdultos());
        reserva.setCriancas(entity.getCriancas());
        return reserva;
    }

    // Buscar uma reserva por ID
    public Reserva buscarReservaPorId(Long id) {
        Optional<ReservaEntity> reservaEntity = reservaRepository.findById(id.intValue());
        return reservaEntity.map(this::toModel).orElse(null);
    }

    // Salvar nova reserva
    public Reserva salvarReserva(Reserva reserva) {
        ReservaEntity reservaEntity = toEntity(reserva);
        ReservaEntity savedEntity = reservaRepository.save(reservaEntity);
        return toModel(savedEntity);
    }

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        List<ReservaEntity> entities = reservaRepository.findAll();
        List<Reserva> reservas = new ArrayList<>();
        for (ReservaEntity entity : entities) {
            reservas.add(toModel(entity));
        }
        return reservas;
    }

    // Deletar uma reserva por ID
    public void deletarReserva(Long id) {
        reservaRepository.deleteById(id.intValue());
    }

// Atualizar uma reserva existente
    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        Optional<ReservaEntity> optionalReserva = reservaRepository.findById(id.intValue());
        if (optionalReserva.isPresent()) {
            ReservaEntity reservaEntity = optionalReserva.get();
            reservaEntity.setNome(reservaAtualizada.getNome());
            reservaEntity.setEmail(reservaAtualizada.getEmail());

            // Converter String para LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            reservaEntity.setDataEntrada(LocalDate.parse(reservaAtualizada.getDataEntrada(), formatter));
            reservaEntity.setDataSaida(LocalDate.parse(reservaAtualizada.getDataSaida(), formatter));

            reservaEntity.setObservacoes(reservaAtualizada.getObservacoes());
            reservaEntity.setAdultos(reservaAtualizada.getAdultos());
            reservaEntity.setCriancas(reservaAtualizada.getCriancas());

            ReservaEntity savedEntity = reservaRepository.save(reservaEntity);
            return toModel(savedEntity);
        }
        return null;
    }

}
