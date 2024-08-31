package com.personal.finances.controller;

import com.personal.finances.model.Despesa;
import com.personal.finances.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.personal.finances.util.Utils.isNotNull;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;

    @PostMapping
    public ResponseEntity<Despesa> cadstrarDespesa(@RequestBody Despesa despesa) {
        try {
            Despesa despesaCadastrada = despesaRepository.save(despesa);
            return ResponseEntity.status(HttpStatus.CREATED).body(despesaCadastrada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Despesa>> buscarDespesas() {
        try {
            List<Despesa> despesas = despesaRepository.findAll();
            return ResponseEntity.ok(despesas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Despesa> buscarDespesaPorId(@PathVariable Long id) {
        try {
            Despesa despesa = despesaRepository.findById(id).orElse(null);
            if (isNotNull(despesa)) {
                return ResponseEntity.ok(despesa);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
