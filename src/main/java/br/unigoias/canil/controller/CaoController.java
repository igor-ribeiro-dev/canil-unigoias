package br.unigoias.canil.controller;

import br.unigoias.canil.model.Cao;
import br.unigoias.canil.service.CaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/caes")
public class CaoController {

    @Autowired
    private CaoService caoService;

    @GetMapping
    public List<Cao> index() {
        return caoService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Cao> show(@PathVariable Long id) {
        try {
            Cao cao = caoService.findById(id);
            return ResponseEntity.ok(cao);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Cao> update(@PathVariable Long id, @RequestBody Cao cao) {
        try {
            Cao novaCao = caoService.updateById(id, cao);
            return ResponseEntity.ok(novaCao);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            caoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
