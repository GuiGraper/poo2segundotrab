package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Disciplina;
import com.leandersonandre.agenda.core.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    // tirar o implement e deixar o modo de interface
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void salvarDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listarDisciplinas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina obterDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }
}
