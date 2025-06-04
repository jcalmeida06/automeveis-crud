package com.projeto.automoveis.controller;

import com.projeto.automoveis.models.CarrosModel;
import com.projeto.automoveis.service.AutomoveisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarrosController {

    @Autowired
    private AutomoveisService automoveisService;

    @PostMapping
    public ResponseEntity<CarrosModel> criar(@RequestBody CarrosModel carro) {
        return ResponseEntity.ok(automoveisService.salvar(carro));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarrosModel> buscarPorId(@PathVariable Long id) {
        return automoveisService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<CarrosModel>> listarTodos() {
        return ResponseEntity.ok(automoveisService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarrosModel> atualizar(@PathVariable Long id, @RequestBody CarrosModel carro) {
        try {
            return ResponseEntity.ok(automoveisService.atualizar(id, carro));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        automoveisService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}