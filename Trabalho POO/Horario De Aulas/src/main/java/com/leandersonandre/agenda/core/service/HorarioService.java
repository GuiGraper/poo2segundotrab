package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Horario;
import com.leandersonandre.agenda.core.repository.HorarioRepository;
import com.leandersonandre.agenda.core.repository.HorarioRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;

    public void save(Horario horario) {
        horarioRepository.save(horario);
    }

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }
}