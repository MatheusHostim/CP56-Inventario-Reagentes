package com.sistemaempresa.invreagentes.service;

import com.sistemaempresa.invreagentes.dto.ReagenteDTO;
import com.sistemaempresa.invreagentes.mapper.ReagenteMapper;
import com.sistemaempresa.invreagentes.model.Reagente;
import com.sistemaempresa.invreagentes.repository.ReagenteRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReagenteService {

    private final ReagenteRepository repository;

    public ReagenteService(ReagenteRepository repository) {
        this.repository = repository;
    }

    public List<ReagenteDTO> listarTodos() {
        return repository.findAll().stream().map(ReagenteMapper::toDTO).collect(Collectors.toList());
    }

    public ReagenteDTO buscarPorId(Long id) {
        Reagente r = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reagente não encontrado"));
        return ReagenteMapper.toDTO(r);
    }

    public ReagenteDTO criar(ReagenteDTO dto) {
        Reagente r = ReagenteMapper.toEntity(dto);
        Reagente salvo = repository.save(r);
        return ReagenteMapper.toDTO(salvo);
    }

    public ReagenteDTO atualizar(Long id, ReagenteDTO dto) {
        Reagente existente = repository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reagente não encontrado"));
        // atualiza campos
        existente.setNome(dto.nome());
        existente.setQuantidade(dto.quantidade());
        existente.setLote(dto.lote());
        existente.setValidade(dto.validade());
        // fornecedor: sobrescreve se presente
        existente.setFornecedor(ReagenteMapper.toEntity(dto).getFornecedor());
        Reagente salvo = repository.save(existente);
        return ReagenteMapper.toDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reagente não encontrado");
        }
        repository.deleteById(id);
    }
}