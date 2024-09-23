package com.project.DevHotel.data;

import com.project.DevHotel.model.Reserva;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

}