package com.leandersonandre.agenda.core.repository;

import com.leandersonandre.agenda.core.entity.HorarioAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioAulaRepository extends JpaRepository<HorarioAula, Long> {
}
