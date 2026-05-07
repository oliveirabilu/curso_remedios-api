package com.examplemateuscurso.cursoremedios.controller;

import com.examplemateuscurso.cursoremedios.entities.Remedio;
import com.examplemateuscurso.cursoremedios.record.DadosAtualRemedios;
import com.examplemateuscurso.cursoremedios.record.DadosEntradaRemedios;
import com.examplemateuscurso.cursoremedios.record.DadosListagemRemedios;
import com.examplemateuscurso.cursoremedios.services.RemedioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("remedios")
public class RemedioController {
 private final RemedioService remedioService;
    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }
 private Remedio toEntity(DadosEntradaRemedios dados){
   return new Remedio(dados.nome(),
     dados.via(),
     dados.lote(),
     dados.quantidade(),
     dados.validade(),
     dados.laboratorio(),
           dados.ativo());
    }

    @PostMapping
    public ResponseEntity<Remedio> cadastrar(@RequestBody @Valid DadosEntradaRemedios dados,
                                             UriComponentsBuilder uriBuilder){
        Remedio remedio = toEntity(dados);
        Remedio created = remedioService.save(remedio);
        var uri=uriBuilder.path("/remedios/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedios>> listar(){
        var lista=remedioService.findAllByAtivoTrue();
        return ResponseEntity.ok().body(lista);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        remedioService.deleteById(id);
        return ResponseEntity.ok().build();
}
    @PutMapping
    public ResponseEntity<DadosAtualRemedios> atualizar(@RequestBody @Valid DadosAtualRemedios dados){
   remedioService.pegarporreferencia(dados);
    return ResponseEntity.ok().build();

}
    @DeleteMapping("inativar/{id}")
    public ResponseEntity<?>inativar (@PathVariable Long id){
        remedioService.inativar(id);
        return ResponseEntity.ok().build();
    }
    @PutMapping("ativar/{id}")
    public ResponseEntity<Void> reativar(@PathVariable Long id){
        remedioService.reativar(id);
        return ResponseEntity.ok().build();
    }

    }
