package com.project.DevHotel.controller;

import com.project.DevHotel.data.ReservaEntity;
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

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Reserva> editarReserva(@PathVariable Long id, @RequestBody Reserva reservaAtualizada) {
        Reserva reserva = reservaService.atualizarReserva(id, reservaAtualizada);
        return ResponseEntity.ok(reserva);
    }

    @GetMapping("/reservas")
    public ResponseEntity<List> listarReservas() {
        List<ReservaEntity> reservas = reservaService.listarReservas();
        return ResponseEntity.ok(reservas);
    }

    @PostMapping("/novo")
    public ResponseEntity<Reserva> criarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.salvarReserva(reserva);
        return ResponseEntity.ok(novaReserva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obterReserva(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarReservaPorId(id);
        return reserva != null ? ResponseEntity.ok(reserva) : ResponseEntity.notFound().build();
    }
}