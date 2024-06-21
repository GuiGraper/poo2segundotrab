package com.leandersonandre.agenda.core.service;

import com.leandersonandre.agenda.core.entity.Colaborador;
import com.leandersonandre.agenda.core.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorService {
// tirar o implement e deixar o modo de interface
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public List<Colaborador> listarColaboradores() {
        return colaboradorRepository.findAll();
    }

    public Colaborador obterColaboradorPorId(Long id) {
        return colaboradorRepository.findById(id).orElse(null);
    }

    public void salvarColaborador(Colaborador colaborador) {
        colaboradorRepository.save(colaborador);
    }
}
