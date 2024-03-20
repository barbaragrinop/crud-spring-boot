package com.gerenciadortarefas.gerenciadordetarefas.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciadortarefas.gerenciadordetarefas.bean.Tarefa;
import com.gerenciadortarefas.gerenciadordetarefas.service.TarefaService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService _service;

    @GetMapping("/getTarefas") // http://localhost:8080/tarefas/getTarefas
    public ResponseEntity<List<Tarefa>> getTarefas() {
        List<Tarefa> tarefas = _service.getAll();

        if (tarefas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/getTarefaById") // http://localhost:8080/tarefas/getTarefaById?id=1
    public ResponseEntity<Tarefa> getTarefaById(@RequestParam Long id) {
        Tarefa tarefa = _service.getTarefa(id);

        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tarefa);
    }

    @PostMapping("/criaTarefa") // http://localhost:8080/tarefas/criaTarefa
    public ResponseEntity<?> criaTarefa(@RequestBody Tarefa tarefa) {

        if (tarefa.getNome() == null || tarefa.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Nome é um campo obrigatório");
        }

        if (tarefa.getDescricao() == null || tarefa.getDescricao().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Descrição é um campo obrigatório");
        }

        if (tarefa.getStatus() == null || tarefa.getStatus().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Status é um campo obrigatório");
        }

        if (tarefa.getDtInicio() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de início é um campo obrigatório");
        }

        if (tarefa.getDtFim() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de fim é um campo obrigatório");
        }

        _service.adcTarefa(tarefa);

        return ResponseEntity.ok(tarefa);
    }

    @PutMapping("/atualizaTarefa") // http://localhost:8080/tarefas/atualizaTarefa
    public ResponseEntity<?> atualizaTarefa(@RequestBody Tarefa tarefa) {
        if (tarefa.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id é um campo obrigatório");
        }

        _service.atualizaTarefa(tarefa);

        return ResponseEntity.ok(tarefa);
    }

    @DeleteMapping("/deletaTarefa") // http://localhost:8080/tarefas/deletaTarefa?id=1
    public ResponseEntity<?> deletaTarefa(@RequestParam Long id) {
        _service.deletarTarefa(id);

        return ResponseEntity.ok().build();
    }
}
