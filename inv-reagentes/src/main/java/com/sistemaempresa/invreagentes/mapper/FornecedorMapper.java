package com.sistemaempresa.invreagentes.mapper;

import com.sistemaempresa.invreagentes.dto.FornecedorDTO;
import com.sistemaempresa.invreagentes.model.Fornecedor;

public class FornecedorMapper {

    public static FornecedorDTO toDTO(Fornecedor f) {
        if (f == null) return null;
        return new FornecedorDTO(f.getId(), f.getNome(), f.getContato());
    }

    public static Fornecedor toEntity(FornecedorDTO dto) {
        if (dto == null) return null;
        Fornecedor f = new Fornecedor();
        if (dto.id() != null) {
            f.setId(dto.id());
        }
        f.setNome(dto.nome());
        f.setContato(dto.contato());
        return f;
    }
}