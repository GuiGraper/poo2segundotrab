package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Materias;
import com.leandersonandre.agenda.core.repository.MateriasRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MateriasServico {

    @Autowired
    MateriasRepository materiasRepository;

    public List<Materias> obterTodos() {
        return materiasRepository.findAll();
    }

    public Optional<Materias> obterPeloId(long id) {
        return materiasRepository.findById(id);
    }

    public void salvar(Materias materias) {
        if(Strings.isBlank(materias.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        if(Strings.isBlank(materias.getSobrenome())){
            throw new RuntimeException("Favor informar o sobrenome");
        }
        materiasRepository.save(materias);
    }
}
