package com.project.DevHotel.data;

import com.project.DevHotel.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository {

    private List<Reserva> reservas = new ArrayList<>();
    private Long nextId = 1L;

    public List<Reserva> findAll() {
        return reservas;
    }

    public Optional<Reserva> findById(Long id) {
        return reservas.stream().filter(reserva -> reserva.getId().equals(id)).findFirst();
    }

    public Reserva save(Reserva reserva) {
        if (reserva.getId() == null) {
            reserva.setId(nextId++);
        }
        reservas.add(reserva);
        return reserva;
    }

    public void deleteById(Long id) {
        reservas.removeIf(reserva -> reserva.getId().equals(id));
    }
}
