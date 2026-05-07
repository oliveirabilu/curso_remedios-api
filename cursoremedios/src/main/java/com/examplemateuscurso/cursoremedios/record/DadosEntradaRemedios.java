package com.examplemateuscurso.cursoremedios.record;

import com.examplemateuscurso.cursoremedios.enumm.Laboratorio;
import com.examplemateuscurso.cursoremedios.enumm.Via;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosEntradaRemedios(
        @NotBlank
        String nome,
        @Enumerated
        Via via,
        @NotBlank
        String lote,
        int quantidade,
        @Future
        LocalDate validade,
        @Enumerated
        Laboratorio laboratorio,
        Boolean ativo

) {

}
