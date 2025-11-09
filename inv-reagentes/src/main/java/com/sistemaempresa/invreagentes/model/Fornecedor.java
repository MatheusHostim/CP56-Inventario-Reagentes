package com.sistemaempresa.invreagentes.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String contato;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reagente> reagentes = new ArrayList<>();

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public List<Reagente> getReagentes() { return reagentes; }
    public void setReagentes(List<Reagente> reagentes) { this.reagentes = reagentes; }
}