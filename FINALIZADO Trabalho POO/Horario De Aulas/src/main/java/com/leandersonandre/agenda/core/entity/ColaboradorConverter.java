package com.leandersonandre.agenda.core.entity;

import com.leandersonandre.agenda.core.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ColaboradorConverter implements Converter<String, Colaborador> {

    @Autowired
    private ColaboradorService colaboradorService;

    @Override
    public Colaborador convert(String source) {
        Long id = Long.parseLong(source);
        return colaboradorService.obterColaboradorPorId(id);
    }
}
//Conversor: Transforma dados de um formato (string) para outro (objeto Disciplina).