package com.leandersonandre.agenda.core.repository;
import java.util.List;
import com.leandersonandre.agenda.core.entity.Horario;
import com.leandersonandre.agenda.core.entity.Materias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
}