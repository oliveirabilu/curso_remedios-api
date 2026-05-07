package com.examplemateuscurso.cursoremedios.record;

import com.examplemateuscurso.cursoremedios.entities.Remedio;
import com.examplemateuscurso.cursoremedios.enumm.Via;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualRemedios(
        @NotNull
        Long id,
        String nome,
        Via via,
        String lote,
        Boolean ativo
) {
    public DadosAtualRemedios(@Valid Remedio remedio){
        this(remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
        remedio.getAtivo());
    }
}
