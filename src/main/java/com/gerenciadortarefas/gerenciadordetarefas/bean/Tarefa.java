package com.gerenciadortarefas.gerenciadordetarefas.bean;

import java.util.Date;

public class Tarefa {

    private static final long serialVersionUID = -4205156507257923921L;
    private static Long nextId = 1L; // auto incremento static para manter o mesmo valor para todas as instancias
    // para incrementar o id correto
    private Long id;
    private String _nome;
    private String _descricao;
    private String _status;
    private Date _dtInicio;
    private Date _dtFim;

    public Tarefa() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return _nome;
    }

    public void setNome(String nome) {
        this._nome = nome;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String descricao) {
        this._descricao = descricao;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        this._status = status;
    }

    public Date getDtInicio() {
        return _dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this._dtInicio = dtInicio;
    }

    public Date getDtFim() {
        return _dtFim;
    }

    public void setDtFim(Date dtFim) {
        this._dtFim = dtFim;
    }

    public Long generateId() {
        return nextId++;
    }

    @Override
    public String toString() {
        return "Tarefa [descricao=" + _descricao + ", dtFim=" + _dtFim + ", dtInicio=" + _dtInicio + ", nome=" + _nome
                + ", status=" + _status + "]";
    }
}
