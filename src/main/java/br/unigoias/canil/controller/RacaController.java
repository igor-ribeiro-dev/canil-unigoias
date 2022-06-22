package br.unigoias.canil.controller;

import br.unigoias.canil.model.Raca;
import br.unigoias.canil.service.RacaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/racas")
public class RacaController {

    @Autowired
    private RacaService racaService;

    @GetMapping
    public List<Raca> index() {
        return racaService.findAll();
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
            racaService.updateById(id, raca);
            return ResponseEntity.ok(raca);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
