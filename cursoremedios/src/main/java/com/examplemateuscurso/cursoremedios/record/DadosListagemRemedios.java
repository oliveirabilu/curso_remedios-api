package com.examplemateuscurso.cursoremedios.record;

import com.examplemateuscurso.cursoremedios.entities.Remedio;
import com.examplemateuscurso.cursoremedios.enumm.Laboratorio;
import com.examplemateuscurso.cursoremedios.enumm.Via;

import java.time.LocalDate;

public record DadosListagemRemedios(
        Boolean ativo,
        Long id,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio

) {
    public DadosListagemRemedios(Remedio remedio){
        this(remedio.getAtivo(),
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio());
    }
}
