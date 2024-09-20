package com.project.DevHotel.controller;

import com.project.DevHotel.model.Reserva;
import com.project.DevHotel.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> editarReserva(@PathVariable Long id, @RequestBody Reserva reservaAtualizada) {
        Reserva reserva = reservaService.atualizarReserva(id, reservaAtualizada);
        return ResponseEntity.ok(reserva);
    }
    
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        List<Reserva> reservas = reservaService.listarReservas();
        return ResponseEntity.ok(reservas);
    }
    
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.salvarReserva(reserva);
        return ResponseEntity.ok(novaReserva);
    }



}
