package com.sistemaempresa.invreagentes.mapper;

import com.sistemaempresa.invreagentes.dto.ReagenteDTO;
import com.sistemaempresa.invreagentes.model.Reagente;

public class ReagenteMapper {
    public static ReagenteDTO toDTO(Reagente r) {
        if (r == null) return null;
        return new ReagenteDTO(
            r.getId(),
            r.getNome(),
            r.getQuantidade(),
            r.getLote(),
            r.getValidade(),
            FornecedorMapper.toDTO(r.getFornecedor())
        );
    }

    public static Reagente toEntity(ReagenteDTO dto) {
        if (dto == null) return null;
        Reagente r = new Reagente();
        r.setId(dto.id());
        r.setNome(dto.nome());
        r.setQuantidade(dto.quantidade());
        r.setLote(dto.lote());
        r.setValidade(dto.validade());
        r.setFornecedor(FornecedorMapper.toEntity(dto.fornecedor()));
        return r;
    }
}