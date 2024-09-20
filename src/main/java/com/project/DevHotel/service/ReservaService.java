package com.project.DevHotel.service;

import com.project.DevHotel.data.ReservaRepository;
import com.project.DevHotel.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

 @Autowired
    private ReservaRepository reservaRepository;

    // Salvar nova reserva
    public Reserva salvarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Deletar uma reserva por ID
    public void deletarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    // Atualizar uma reserva existente
    public Reserva atualizarReserva(Long id, Reserva reservaAtualizada) {
        Optional<Reserva> optionalReserva = reservaRepository.findById(id);
        if (optionalReserva.isPresent()) {
            Reserva reserva = optionalReserva.get();
            reserva.setNome(reservaAtualizada.getNome());
            reserva.setEmail(reservaAtualizada.getEmail());
            reserva.setDataEntrada(reservaAtualizada.getDataEntrada());
            reserva.setDataSaida(reservaAtualizada.getDataSaida());
            reserva.setObservacoes(reservaAtualizada.getObservacoes());
            reserva.setAdultos(reservaAtualizada.getAdultos());
            reserva.setCriancas(reservaAtualizada.getCriancas());
            return reservaRepository.save(reserva);
        }
        return null;
    }
}
