package com.sistemaempresa.invreagentes.dto;

import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO(
        Long id,
        @NotBlank(message = "nome do fornecedor é obrigatório") String nome,
        String contato
) {}