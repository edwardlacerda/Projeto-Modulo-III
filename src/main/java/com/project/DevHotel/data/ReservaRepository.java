package com.project.DevHotel.data;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer> {

}