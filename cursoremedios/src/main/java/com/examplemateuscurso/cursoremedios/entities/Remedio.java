package com.examplemateuscurso.cursoremedios.entities;

import com.examplemateuscurso.cursoremedios.enumm.Laboratorio;
import com.examplemateuscurso.cursoremedios.enumm.Via;
import com.examplemateuscurso.cursoremedios.record.DadosAtualRemedios;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "TB_REMEDIOS")
@AllArgsConstructor
@Setter
@EqualsAndHashCode
public class Remedio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Via via;
    private String lote;
    private int quantidade;
    private LocalDate validade;
    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;
    private Boolean ativo;


    public Remedio() {
    }
    public Remedio(String nome,
                   Via via,
                   String lote,
                   int quantidade,
                   LocalDate validade,
                   Laboratorio laboratorio,
                   Boolean ativo) {
        this.nome=nome;
        this.via=via;
        this.lote=lote;
        this.quantidade=quantidade;
        this.validade=validade;
        this.laboratorio=laboratorio;
        this.ativo=ativo;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Via getVia() {
        return via;
    }
    public void setVia(Via via) {
        this.via = via;
    }
    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getValidade() {
        return validade;
    }
    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
    public Laboratorio getLaboratorio() {
        return laboratorio;
    }
    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }


    public void atualizarRemedio(DadosAtualRemedios dados){
        if (dados.nome()!=null){
            this.nome= dados.nome();
        }
        if (dados.via()!=null){
            this.via= dados.via();
        }
        if (dados.lote()!=null){
            this.lote= dados.lote();
        }
    }
    public void reativar() {
        this.ativo=true;
    }
    public void inativar() {
        this.ativo=false;
    }
}
