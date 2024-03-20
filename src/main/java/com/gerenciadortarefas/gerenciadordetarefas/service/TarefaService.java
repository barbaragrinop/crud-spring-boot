package com.gerenciadortarefas.gerenciadordetarefas.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gerenciadortarefas.gerenciadordetarefas.bean.Tarefa;

@Service
public class TarefaService {

    private List<Tarefa> tarefas = new ArrayList<Tarefa>();

    public TarefaService() {
        // tarefa estatica inicial
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1082934L);
        tarefa.setNome("Tarefa 1");
        tarefa.setDescricao("Descricao da tarefa 1");
        tarefa.setStatus("Pendente");
        tarefa.setDtInicio(new Date());
        tarefa.setDtFim(new Date());
        tarefas.add(tarefa);
    }

    public Tarefa find(Long id) {
        for (Tarefa tarefaAtual : tarefas) {
            if (tarefaAtual.getId().equals(id)) {
                return tarefaAtual;
            }
        }
        return null;
    }

    public void adcTarefa(Tarefa tarefa) {

        tarefa.setId(tarefa.generateId());
        tarefas.add(tarefa);
    }

    public List<Tarefa> getAll() {
        return tarefas;
    }

    public Tarefa getTarefa(Long id) {
        return this.find(id);
    }

    public void atualizaTarefa(Tarefa tarefa) {
        Tarefa trfa = this.find(tarefa.getId());

        if (trfa == null) {
            throw new RuntimeException("Tarefa não existe");
        }

        trfa.setNome(tarefa.getNome());
        trfa.setDescricao(tarefa.getDescricao());
        trfa.setStatus(tarefa.getStatus());
        trfa.setDtInicio(tarefa.getDtInicio());
        trfa.setDtFim(tarefa.getDtFim());
    }

    public void deletarTarefa(Long id) {
        Tarefa trfa = this.find(id);

        if (trfa == null) {
            throw new RuntimeException("Tarefa não existe");
        }

        tarefas.remove(trfa);
    }

}
