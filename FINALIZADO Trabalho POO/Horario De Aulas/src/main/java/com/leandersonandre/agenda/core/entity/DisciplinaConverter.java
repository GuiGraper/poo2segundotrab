package com.leandersonandre.agenda.core.entity;

import com.leandersonandre.agenda.core.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaConverter implements Converter<String, Disciplina> {

    @Autowired
    private DisciplinaService disciplinaService;

    @Override
    public Disciplina convert(String source) {
        Long id = Long.parseLong(source);
        return disciplinaService.obterDisciplinaPorId(id);
    }
}
//esse conversor  pega esse nome de disciplina e busca o objeto disciplina tentando achar