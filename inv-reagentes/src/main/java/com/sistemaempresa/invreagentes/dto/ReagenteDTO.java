package com.sistemaempresa.invreagentes.dto;

import java.time.LocalDate;

public record ReagenteDTO(Long id, String nome, int quantidade, String lote, LocalDate validade, FornecedorDTO fornecedor) {}