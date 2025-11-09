package com.sistemaempresa.invreagentes.controller;

import com.sistemaempresa.invreagentes.dto.ReagenteDTO;
import com.sistemaempresa.invreagentes.service.ReagenteService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/reagentes")
public class ReagenteController {

    private final ReagenteService service;

    public ReagenteController(ReagenteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ReagenteDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReagenteDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ReagenteDTO> criar(@RequestBody ReagenteDTO dto) {
        ReagenteDTO criado = service.criar(dto);
        return ResponseEntity.created(URI.create("/reagentes/" + criado.id())).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReagenteDTO> atualizar(@PathVariable Long id, @RequestBody ReagenteDTO dto) {
        ReagenteDTO atualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}