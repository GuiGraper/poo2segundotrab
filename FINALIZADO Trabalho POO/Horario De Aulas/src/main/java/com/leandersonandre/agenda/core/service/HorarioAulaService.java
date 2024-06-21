package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.HorarioAula;
import com.leandersonandre.agenda.core.repository.HorarioAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioAulaService {
    // tirar o implement e deixar o modo de interface
    @Autowired
    private HorarioAulaRepository horarioAulaRepository;

    public List<HorarioAula> listarHorariosAula() {
        return horarioAulaRepository.findAll();
    }

    public void salvarHorarioAula(HorarioAula horarioAula) {
        horarioAulaRepository.save(horarioAula);
    }
}
