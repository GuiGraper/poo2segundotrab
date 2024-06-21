package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Professor;
import com.leandersonandre.agenda.core.repository.ProfessorRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorServico {
    // tirar o implement e deixar o modo de interface
    @Autowired
    ProfessorRepository professorRepository;

    public List<Professor> obterTodos() {
        return professorRepository.findAll();
    }

    public Optional<Professor> obterPeloId(long id) {
        return professorRepository.findById(id);
    }

    public void salvar(Professor professor) {
        if(Strings.isBlank(professor.getNome())){
            throw new RuntimeException("Favor informar o nome");
        }
        if(Strings.isBlank(professor.getSobrenome())){
            throw new RuntimeException("Favor informar o sobrenome");
        }
        professorRepository.save(professor);
    }
}
