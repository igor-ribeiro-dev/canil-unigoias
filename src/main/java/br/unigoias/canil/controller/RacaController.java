package br.unigoias.canil.controller;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.model.Raca;
import br.unigoias.canil.service.CaoService;
import br.unigoias.canil.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/racas")
@CrossOrigin(origins = "*")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping
    public List<Raca> index() {
        return racaService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Raca> show(@PathVariable Long id) {
        try {
            Raca raca = racaService.findById(id);
            return ResponseEntity.ok(raca);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Raca> create(@RequestBody Raca raca) {
        try {
            Raca novaRaca = racaService.create(raca);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaRaca);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Raca> update(@PathVariable Long id, @RequestBody Raca raca) {
        try {
            Raca novaRaca = racaService.updateById(id, raca);
            return ResponseEntity.ok(novaRaca);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            racaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("{id}/caes")
    public ResponseEntity<Cao> createCao(@PathVariable Long id, @RequestBody Cao cao) {
        try {
            Cao novoCao = racaService.createCaoByRacaId(id, cao);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCao);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
