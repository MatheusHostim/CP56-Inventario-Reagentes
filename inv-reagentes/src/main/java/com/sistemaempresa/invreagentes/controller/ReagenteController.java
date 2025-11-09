package com.sistemaempresa.invreagentes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReagenteController {

    @GetMapping("/reagentes")
    public String listarReagentes() {
        return "Sistema de Inventário de Reagentes funcionando!";
    }
}