package com.examplemateuscurso.cursoremedios.services;

import com.examplemateuscurso.cursoremedios.entities.Remedio;
import com.examplemateuscurso.cursoremedios.record.DadosAtualRemedios;
import com.examplemateuscurso.cursoremedios.record.DadosListagemRemedios;
import com.examplemateuscurso.cursoremedios.repositories.RemedioRepositorio;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.List;

@Service
public class RemedioService {
    private final RemedioRepositorio remedioRepositorio;

    public RemedioService(RemedioRepositorio remedioRepositorio) {
        this.remedioRepositorio = remedioRepositorio;
    }

    @Transactional
    public Remedio save(Remedio remedio) {
        return remedioRepositorio.save(remedio);
    }

    public List<DadosListagemRemedios> findAllByAtivoTrue() {
        return remedioRepositorio.findAllByAtivoTrue()
                .stream()
                .map(DadosListagemRemedios::new)
                .toList();
    }

    @Transactional
    public void deleteById(Long id) {

        remedioRepositorio.deleteById(id);
    }
    @Transactional
    public DadosAtualRemedios pegarporreferencia(DadosAtualRemedios dados) {
        var remedio = remedioRepositorio.getReferenceById(dados.id());
        remedio.atualizarRemedio(dados);
        return new DadosAtualRemedios(remedio);
    }
    @Transactional
    public void inativar(Long id){
        var remedioId = remedioRepositorio.getReferenceById(id);
        remedioId.inativar();
    }
    @Transactional
    public void reativar(Long id){
        var remedioId = remedioRepositorio.getReferenceById(id);
        remedioId.reativar();
    }

}
